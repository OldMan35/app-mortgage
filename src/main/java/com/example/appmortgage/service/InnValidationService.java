package com.example.appmortgage.service;

import com.example.appmortgage.common.InnValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class InnValidationService implements ConstraintValidator<InnValidation, String> {

    private static final Pattern innPatter = Pattern.compile("\\d{10}|\\d{12}");
    private static final int[] checkArr = new int[]{3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};

    @Override
    public void initialize(InnValidation innValidation) {
    }

    @Override
    public boolean isValid(String inn, ConstraintValidatorContext cxt) {
        inn = inn.trim();
        if (!innPatter.matcher(inn).matches()) {
            return false;
        }
        int length = inn.length();
        if (length == 12) {
            return checkSum(inn, 2, 1) && checkSum(inn, 1, 0);
        } else {
            return checkSum(inn, 1, 2);
        }
    }

    private static boolean checkSum(String inn, int offset, int arrOffset) {
        int sum = 0;
        int length = inn.length();
        for (int i = 0; i < length - offset; i++) {
            sum += (inn.charAt(i) - '0') * checkArr[i + arrOffset];
        }
        return (sum % 11) % 10 == inn.charAt(length - offset) - '0';
    }
}


