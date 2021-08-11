package com.example.appmortgage.service;

import com.example.appmortgage.model.MortgageClients;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MortgageClientsServiceTest {

    @Autowired
    private MortgageClientsService mortgageClientsService;

    @Test
    public void createValidRequest() {
        MortgageClients mortgageClients = MortgageClients.builder()
                .id(0)
                .nameOfBuyers("Василий")
                .patronymicOfBuyers("Васильевич")
                .surnameOfBuyers("Васильев")
                .phoneNumberOfBuyers("89116665533")
                .loanAmount(1500000)
                .loanTerm(5)
                .estateObject("квартира")
                .costObject(2000000)
                .innOfBuyers("502805064090")
                .nameOfSellers("Михаил")
                .patronymicOfSellers("Михайлович")
                .surnameOfSellers("Михайлов")
                .innInd("502805064090")
                .nameOrganization("ООО Рога и копыта")
                .innOrg("3525422150")
                .ownRights("Выписка из ЕГРН")
                .build();
        mortgageClientsService.create(mortgageClients);
        List<MortgageClients> result = mortgageClientsService.getAll();
        Assert.assertNotNull(result);
    }
}