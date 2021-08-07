package com.example.appmortgage.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class IndividualInnValidationService {

    private final Pattern patternCheckInn = Pattern.compile("\\d{12}");
    private final int[] checkArrInnIndividual = new int[]{3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};

    public boolean validationInn(String innIndividual) {
        innIndividual = innIndividual.trim();
        if (!patternCheckInn.matcher(innIndividual).matches()) {
            return false;
        }
        if (innIndividual.length() == 12) {
            return checkNumber(innIndividual, 2, 1) && checkNumber(innIndividual, 1, 0);
        } else {
            return checkNumber(innIndividual, 1, 2);
        }
    }

    private boolean checkNumber(String innIndividual, int offset, int arrOffset) {
        int sum = 0;
        int length = innIndividual.length();
        for (int i = 0; i < length - offset; i++) {
            sum += (innIndividual.charAt(i) - '0') * checkArrInnIndividual[i + arrOffset];
        }
        return (sum % 11) % 10 == innIndividual.charAt(length - offset) - '0';
    }
}
