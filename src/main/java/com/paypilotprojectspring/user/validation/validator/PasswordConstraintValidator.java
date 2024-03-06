package com.paypilotprojectspring.user.validation.validator;

import com.google.common.base.Joiner;
import com.paypilotprojectspring.user.validation.ValidPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.passay.*;

import java.util.Arrays;
import java.util.Base64;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    private final Base64.Decoder decoder = Base64.getDecoder();

    public static PasswordValidator getPasswordValidator() {
        return new PasswordValidator(Arrays.asList(
                new LengthRule(8, 30),
                new UppercaseCharacterRule(1),
                new LowercaseCharacterRule(1),
                new DigitCharacterRule(1),
                new WhitespaceRule()));
    }

    @Override
    public void initialize(final ValidPassword arg0) {

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        // @formatter:off
        final String decodedPassword = new String(decoder.decode(password));

        final PasswordValidator validator = getPasswordValidator();
        final RuleResult result = validator.validate(new PasswordData(decodedPassword));
        if (result.isValid()) {
            return true;
        }
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(Joiner.on(",").join(validator.getMessages(result)))
                .addConstraintViolation();
        return false;
    }

}
