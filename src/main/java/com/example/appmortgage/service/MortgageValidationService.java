package com.example.appmortgage.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class MortgageValidationService {

    private static final Pattern patternCheckInn = Pattern.compile("\\d{10}|\\d{12}");
    private static final int[] checkArrInnOrg = new int[]{2, 4, 10, 3, 5, 9, 4, 6, 8};
    private static final int[] checkArrInnIndiv = new int[]{3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};

    public static boolean validationInn(String innIndiv, String innOrg) {
        innIndiv = innIndiv.trim();
        innOrg = innOrg.trim();
        if (!patternCheckInn.matcher(innIndiv).matches() && !patternCheckInn.matcher(innOrg).matches()) {
            return false;
        }
        if (innIndiv.length() == 12) {
            return INNStep(innIndiv, 2, 1) && INNStep(innIndiv, 1, 0);
        } else {
            return INNStep(innIndiv, 1, 2);
        }
    }

    private static boolean INNStep(String innIndiv, int offset, int arrOffset) {
        int sum = 0;
        int length = innIndiv.length();
        for (int i = 0; i < length - offset; i++) {
            sum += (innIndiv.charAt(i) - '0') * checkArrInnIndiv[i + arrOffset];
        }
        return (sum % 11) % 10 == innIndiv.charAt(length - offset) - '0';
    }

}
