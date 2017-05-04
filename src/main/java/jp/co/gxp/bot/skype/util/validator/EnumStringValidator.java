package jp.co.gxp.bot.skype.util.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Enumで定義されているかをチェックするValidator
 */
public class EnumStringValidator implements ConstraintValidator<EnumString, String> {
    
    private Class<? extends ApiRequestEnum> enumClass;
    private boolean required;
    
    @Override
    public void initialize(EnumString constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required && value == null) {
            return false;
        }
        for (ApiRequestEnum e : enumClass.getEnumConstants()) {
            if (e.getApiValue().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
