 package com.example.appmortgage;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IndividualInnValidationServiceTest {

    @InjectMocks
    private IndividualInnValidationService validationService;

    @Test
    public void test() {
        //given
        String inn = "502805064090";
        //when
        boolean result = validationService.validationInn(inn);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void test2() {
        //given
        String inn = "hui805064090";
        //when
        boolean result = validationService.validationInn(inn);
        //then
        Assert.assertFalse(result);
    }
}
