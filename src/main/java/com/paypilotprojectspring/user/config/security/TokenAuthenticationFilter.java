package com.paypilotprojectspring.user.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

  private final TokenProvider tokenProvider;
  private final HandlerExceptionResolver handlerExceptionResolver;

  @Override
  protected void doFilterInternal(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      FilterChain filterChain)
      throws ServletException, IOException {
    String token = tokenProvider.getTokenFromRequest(httpServletRequest);
    try {
      UsernamePasswordAuthenticationToken authentication =
          tokenProvider.getAuthenticationFromToken(token);
      authentication.setDetails(
          new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
      SecurityContextHolder.getContext().setAuthentication(authentication);
      filterChain.doFilter(httpServletRequest, httpServletResponse);
    } catch (Exception exception) {
      handlerExceptionResolver.resolveException(
          httpServletRequest, httpServletResponse, null, exception);
    }
  }
}
