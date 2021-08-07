package com.example.appmortgage;

import java.util.regex.Pattern;

public class testCheckInn {
    private static final Pattern patternCheckInn = Pattern.compile("\\d{10}|\\d{12}");

    public static void main(String[] args) {
        if (checkInn("123456789144")) {
            System.out.println("Инн корректен.");
        } else {
            System.out.println("Инн не корректен.");
        }
        ;
    }

    private static boolean checkInn(String inn) {
        inn.trim();
        if (!patternCheckInn.matcher(inn).matches()) {
            return false;
        } else {
            return true;
        }
//        if (inn.length() == 12) {
//            return INNStep(innIndiv, 2, 1) && INNStep(innIndiv, 1, 0);
//        } else {
//            return INNStep(innIndiv, 1, 2);
//        }

    }
}
