package com.example.appmortgage;

import java.util.regex.Pattern;

public class testCheckOrganizationInnValidationService {
    private static final Pattern patternCheckInn = Pattern.compile("\\d{10}");
    private static final int[] checkArrInnOrganization = new int[]{2, 4, 10, 3, 5, 9, 4, 6, 8};
    private static final String innOrganization = "3525422150";


    public static void main(String[] args) {
        if (checkInn(innOrganization)) {
            System.out.println("Инн корректен.");
        } else {
            System.out.println("Инн не корректен.");
        }
    }

    private static boolean checkInn(String inn) {
        inn.trim();
        if (!patternCheckInn.matcher(inn).matches()) {
            return false;
        } else {
            return checkNumber(inn, 1);
        }
    }

    private static boolean checkNumber(String inn, int offset) {
        int sum = 0;
        int length = inn.length();
        for (int i = 0; i < length - offset; i++) {
            sum += (inn.charAt(i) - '0') * checkArrInnOrganization[i];
        }
        return (sum % 11) % 10 == inn.charAt(length - offset) - '0';
    }
}
