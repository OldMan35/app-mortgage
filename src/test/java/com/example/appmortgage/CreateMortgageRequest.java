package com.example.appmortgage;

import com.example.appmortgage.controller.MortgageController;
import com.example.appmortgage.model.MortgageClients;
import com.example.appmortgage.repository.MortgageClientsRepository;
import com.example.appmortgage.service.MortgageClientsService;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CreateMortgageRequest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MortgageClientsService mortgageClientsService;

    //сброс БД после теста
//    @AfterEach
//    public void resetDb() {
//        mortgageClientsRepository.deleteAll();
//    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreateValidRequestMortgage() throws Exception {
        MortgageClients mortgageClients = new MortgageClients(0, "Василий",
                "Васильевич",
                "Васильев",
                "89116665533",
                1500000,
                5,
                "квартира",
                2000000,
                "502805064090",
                "Михаил",
                "Михайлович",
                "Михайлов",
                "502805064090",
                "ООО Рога и копыта",
                "3525422150",
                "Выписка из ЕГРН");
        this.mockMvc.perform(post("/mortgage/create").contentType((MediaType.APPLICATION_JSON))
                .content(objectMapper.writeValueAsString(mortgageClients)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$id").isNumber())
                .andExpect(jsonPath("$.nameOfBuyers").value("Василий"))
                .andExpect(jsonPath("$.patronymicOfBuyers").value("Васильевич"))
                .andExpect(jsonPath("$.surnameOfBuyers").value("Васильев"))
                .andExpect(jsonPath("$.phoneNumberOfBuyers").value("89116665533"))
                .andExpect(jsonPath("$.loanAmount").value("1500000"))
                .andExpect(jsonPath("$.loanTerm").value("5"))
                .andExpect(jsonPath("$.estateObject").value("квартира"))
                .andExpect(jsonPath("$.costObject").value("2000000"))
                .andExpect(jsonPath("$.innOfBuyers").value("502805064090"))
                .andExpect(jsonPath("$.nameOfSellers").value("Михаил"))
                .andExpect(jsonPath("$.patronymicOfSellers").value("Михайлович"))
                .andExpect(jsonPath("$.surnameOfSellers").value("Михайлов"))
                .andExpect(jsonPath("$.innInd").value("502805064090"))
                .andExpect(jsonPath("$.nameOrganization").value("ООО Рога и копыта"))
                .andExpect(jsonPath("$.innOrg").value("3525422150"))
                .andExpect(jsonPath("$.ownRights").value("Выписка из ЕГРН"))
                .andDo(print());
//                .andExpect(status().isOk());
    }

    @Test
    public void testCreateNotValidRequestMortgage() throws Exception {
        MortgageClients mortgageClients = new MortgageClients(0, "Василий",
                "Васильевич",
                "Васильев",
                "89116665533",
                1500000,
                5,
                "квартира",
                2000000,
                "502805064090",
                "Михаил",
                "Михайлович",
                "Михайлов",
                "502805064090",
                "ООО Рога и копыта",
                "0000000000",
                "Выписка из ЕГРН");
        this.mockMvc.perform(post("/mortgage/create").contentType((MediaType.APPLICATION_JSON))
                .content(objectMapper.writeValueAsString(mortgageClients)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$id").isNumber())
                .andExpect(jsonPath("$.nameOfBuyers").value("Василий"))
                .andExpect(jsonPath("$.patronymicOfBuyers").value("Васильевич"))
                .andExpect(jsonPath("$.surnameOfBuyers").value("Васильев"))
                .andExpect(jsonPath("$.phoneNumberOfBuyers").value("89116665533"))
                .andExpect(jsonPath("$.loanAmount").value("1500000"))
                .andExpect(jsonPath("$.loanTerm").value("5"))
                .andExpect(jsonPath("$.estateObject").value("квартира"))
                .andExpect(jsonPath("$.costObject").value("2000000"))
                .andExpect(jsonPath("$.innOfBuyers").value("502805064090"))
                .andExpect(jsonPath("$.nameOfSellers").value("Михаил"))
                .andExpect(jsonPath("$.patronymicOfSellers").value("Михайлович"))
                .andExpect(jsonPath("$.surnameOfSellers").value("Михайлов"))
                .andExpect(jsonPath("$.innInd").value("502805064090"))
                .andExpect(jsonPath("$.nameOrganization").value("ООО Рога и копыта"))
                .andExpect(jsonPath("$.innOrg").value("0000000000"))
                .andExpect(jsonPath("$.ownRights").value("Выписка из ЕГРН"))
                .andDo(print());
//                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testTryGetAllButGetOne() throws Exception {
        MortgageClients mortgageClients = new MortgageClients(0, "Василий",
                "Васильевич",
                "Васильев",
                "89116665533",
                1500000,
                5,
                "квартира",
                2000000,
                "502805064090",
                "Михаил",
                "Михайлович",
                "Михайлов",
                "502805064090",
                "ООО Рога и копыта",
                "3525422150",
                "Выписка из ЕГРН");
        mortgageClientsService.create(mortgageClients);
        this.mockMvc.perform(get("/get-all"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
