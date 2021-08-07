package com.example.appmortgage.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class OrganizationInnValidationService {

    private final Pattern patternCheckInn = Pattern.compile("\\d{10}");
    private final int[] checkArrInnOrganization = new int[]{2, 4, 10, 3, 5, 9, 4, 6, 8};

    public boolean validationInn(String innOrganization) {
        innOrganization = innOrganization.trim();
        if (!patternCheckInn.matcher(innOrganization).matches()) {
            return false;
        } else {
            return checkNumber(innOrganization, 1);
        }
    }

    private boolean checkNumber(String innOrganization, int offset) {
        int sum = 0;
        int length = innOrganization.length();
        for (int i = 0; i < length - offset; i++) {
            sum += (innOrganization.charAt(i) - '0') * checkArrInnOrganization[i];
        }
        return (sum % 11) % 10 == innOrganization.charAt(length - offset) - '0';
    }

}
