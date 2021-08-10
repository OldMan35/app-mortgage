package com.example.appmortgage.common;

import com.example.appmortgage.service.InnValidationService;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = InnValidationService.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface InnValidation {

    String message() default "{Inn}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
