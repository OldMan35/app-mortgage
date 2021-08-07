package com.example.appmortgage.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class IndividualInnValidationService {

    private  final Pattern patternCheckInn = Pattern.compile("\\d{10}|\\d{12}");
    private  final int[] checkArrInnIndividual = new int[]{3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};

    public boolean validationInn(String innIndividual) {
        innIndividual = innIndividual.trim();
        if (!patternCheckInn.matcher(innIndividual).matches()) {
            return false;
        }
        if (innIndividual.length() == 12) {
            return INNStep(innIndividual, 2, 1) && INNStep(innIndividual, 1, 0);
        } else {
            return INNStep(innIndividual, 1, 2);
        }
    }

    private boolean INNStep(String innIndiv, int offset, int arrOffset) {
        int sum = 0;
        int length = innIndiv.length();
        for (int i = 0; i < length - offset; i++) {
            sum += (innIndiv.charAt(i) - '0') * checkArrInnIndividual[i + arrOffset];
        }
        return (sum % 11) % 10 == innIndiv.charAt(length - offset) - '0';
    }

}
