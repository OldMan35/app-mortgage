package com.example.appmortgage.CustomAnnotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = com.example.appmortgage.common.InnValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface InnValidation {

    String message() default "Введено некорректное значение ИНН.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
