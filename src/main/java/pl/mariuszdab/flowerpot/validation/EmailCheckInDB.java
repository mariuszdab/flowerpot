package pl.mariuszdab.flowerpot.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailCheckInDBValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailCheckInDB {

    String message() default "Ten email już istnieje w naszej bazie dancyh!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
