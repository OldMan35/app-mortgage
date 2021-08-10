package com.example.appmortgage.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = InnValidationImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface InnValidation {

    String message() default "Incorrect INN";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
