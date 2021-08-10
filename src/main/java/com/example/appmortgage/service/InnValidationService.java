package com.example.appmortgage.service;

import com.example.appmortgage.common.InnValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InnValidationService implements ConstraintValidator<InnValidation, String> {
    @Override
    public void initialize(InnValidation innValidation) {
    }

    @Override
    public boolean isValid(String inn, ConstraintValidatorContext cxt) {

        return true;
    }

}
