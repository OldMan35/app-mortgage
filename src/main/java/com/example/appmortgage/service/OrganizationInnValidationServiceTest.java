package com.example.appmortgage.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrganizationInnValidationServiceTest {

    @InjectMocks
    private OrganizationInnValidationService validationService;

    @Test
    public void innValidTest() {
        //given
        String inn = "3525422150";
        //when
        boolean result = validationService.validationInn(inn);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void innNotValidTest() {
        //given
        String inn = "ggg3525422150";
        //when
        boolean result = validationService.validationInn(inn);
        //then
        Assert.assertFalse(result);
    }
}
