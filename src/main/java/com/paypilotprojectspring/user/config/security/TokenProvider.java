package com.paypilotprojectspring.user.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TokenProvider {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_KEY = "Bearer ";
    private static final String ID_KEY = "id";
    private static final String EMAIL_KEY = "email";
    private static final String ROLE_KEY = "role";
    private static final String FIRST_LOGIN = "firstLogin";

    private static final Long EXPIRATION_TIME_DAYS = 30L;

    @Value("${security.authentication.jwt.secret}")
    private String secret;

    public String getTokenFromRequest(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION_HEADER);
        return getTokenFromString(token);
    }

    public UsernamePasswordAuthenticationToken getAuthenticationFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        Long id = Long.valueOf(claims.get(ID_KEY).toString());
        String email = claims.get(EMAIL_KEY).toString();
        Collection<? extends GrantedAuthority> authorities = parseRoleFromClaims(claims);

        boolean isFirstLogin = Boolean.parseBoolean(claims.get(FIRST_LOGIN).toString());
        if (isFirstLogin){
      throw new RuntimeException("user_is_logging_in_for_the_first_time");
        }
        UserPrincipal userPrincipal = UserPrincipal.builder()
                .id(id)
                .email(email)
                .authorities(authorities)
                .build();

        return new UsernamePasswordAuthenticationToken(userPrincipal, null, authorities);
    }

    public Long getUserIdFromToken(String token) {
        String tokenFromRequest = getTokenFromString(token);
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(tokenFromRequest)
                .getBody();
        return Long.valueOf(claims.get(ID_KEY).toString());
    }

    public String createTokenFromAuthentication(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Date expirationDate = getExpirationTime(userPrincipal.isFirstLogin());
        return Jwts.builder()
                .claim(ID_KEY, userPrincipal.getId())
                .claim(EMAIL_KEY, userPrincipal.getEmail())
                .claim(ROLE_KEY, buildAuthorities(userPrincipal))
                .claim(FIRST_LOGIN, userPrincipal.isFirstLogin())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

    }

    private Date getExpirationTime(boolean isFirstLogin) {
        return isFirstLogin ? (Date.from(Instant.from(LocalTime.now().plus(15, ChronoUnit.MINUTES)
                .atDate(LocalDate.now())
                .toInstant(ZoneOffset.UTC)))) : (Date.from(Instant.from(LocalDate.now().plusDays(EXPIRATION_TIME_DAYS)
                .atStartOfDay()
                .toInstant(ZoneOffset.UTC))));
    }

    private String buildAuthorities(UserPrincipal userPrincipal){
        return  userPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }

    private String getTokenFromString(String token) {
        if (StringUtils.isNotEmpty(token) && StringUtils.startsWith(token, BEARER_KEY)) {
            return token.substring(BEARER_KEY.length());
        }
        return null;
    }

    private List<SimpleGrantedAuthority> parseRoleFromClaims(Claims claims) {
        String roles = claims.get(ROLE_KEY).toString();
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        String[] multipleRoles = roles.split(",");
        Arrays.stream(multipleRoles).forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.trim())));
        return grantedAuthorities;
    }

}
