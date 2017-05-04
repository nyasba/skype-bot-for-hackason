package jp.co.gxp.bot.skype.util.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Enumで定義されていることをチェックするValidatorのannotation
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EnumStringValidator.class)
public @interface EnumString {
    
    Class<? extends ApiRequestEnum> enumClass();
    
    boolean required() default false;
    
    String message() default "may not be defined at enum";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}
