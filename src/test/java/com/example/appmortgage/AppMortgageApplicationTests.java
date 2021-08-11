package com.example.appmortgage;


import com.example.appmortgage.controller.MortgageController;
import com.example.appmortgage.model.MortgageClients;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AppMortgageApplicationTests {

    @Autowired
    private MortgageController mortgageController;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void mortgageControllerTest() throws Exception {
        assertThat(mortgageController).isNotNull();
    }

    @Test
    @Order(2)
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
        MvcResult result = this.mockMvc.perform(post("/mortgage/create").contentType((MediaType.APPLICATION_JSON))
                .content(objectMapper.writeValueAsString(mortgageClients)))
                .andExpect(status().isCreated())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals("Заявка создана", content);
    }

    @Test
    @Order(3)
    public void testCreateNotValidRequestMortgage() throws Exception {
        MortgageClients mortgageClients = new MortgageClients(
                0,
                null,                 //null
                "Иванович",
                "Иванов",
                "89116665533",
                1500000,
                5,
                "квартира",
                2000000,
                "502805064090ffff",     //notValidINN
                null,                 //null
                "Михайлович",
                "Михайлов",
                "502805064090ffff",        //notValidINN
                "ООО Рога и копыта",
                "3525422150fffff",         //notValidINN
                "Выписка из ЕГРН");
        MvcResult result = this.mockMvc.perform(post("/mortgage/create").contentType((MediaType.APPLICATION_JSON))
                .content(objectMapper.writeValueAsString(mortgageClients)))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assertions.assertTrue(content.contains("Incorrect INN"));
        Assertions.assertTrue(content.contains("The field cannot be empty"));
    }

    @Test
    @Order(4)
    public void testTryGetAllButGetOne() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/mortgage/get-all"))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        MortgageClients[] mortgageClientsArray = objectMapper.readValue(content, MortgageClients[].class);
        MortgageClients mortgageClient = mortgageClientsArray[0];
        Assert.assertEquals("502805064090", mortgageClient.getInnOfBuyers());//getting the buyers by inn
    }
}
