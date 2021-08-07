package com.example.appmortgage;

import java.util.regex.Pattern;

public class testCheckIndividualInnValidationService {
    private static final Pattern patternCheckInn = Pattern.compile("\\d{12}");
    private static final int[] checkArrInnIndividual = new int[]{3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
    private static final String innIndividual = "502805064090";


    public static void main(String[] args) {
        if (checkInn(innIndividual)) {
            System.out.println("Инн корректен.");
        } else {
            System.out.println("Инн не корректен.");
        }
    }

    private static boolean checkInn(String inn) {
        inn.trim();
        if (!patternCheckInn.matcher(inn).matches()) {
            return false;
        }
        if (inn.length() == 12) {
            return checkNumber(inn, 2, 1) && checkNumber(inn, 1, 0);
        } else {
            return checkNumber(inn, 1, 2);
        }
    }

    private static boolean checkNumber(String inn, int offset, int arrOffset) {
        int sum = 0;
        int length = inn.length();
        for (int i = 0; i < length - offset; i++) {
            sum += (inn.charAt(i) - '0') * checkArrInnIndividual[i + arrOffset];
        }
        return (sum % 11) % 10 == inn.charAt(length - offset) - '0';
    }
}
