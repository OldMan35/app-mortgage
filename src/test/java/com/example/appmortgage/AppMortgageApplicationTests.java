package com.example.appmortgage;


import com.example.appmortgage.controller.MortgageController;
import com.example.appmortgage.model.MortgageClients;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
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
class AppMortgageApplicationTests {

    @Autowired
    private MortgageController mortgageController;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void mortgageControllerTest() throws Exception {
        assertThat(mortgageController).isNotNull();
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
        MvcResult result = this.mockMvc.perform(post("/mortgage/create").contentType((MediaType.APPLICATION_JSON))
                .content(objectMapper.writeValueAsString(mortgageClients)))
                .andExpect(status().isCreated())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals("Заявка создана.", content);
    }

    @Test
    public void testCreateNotValidRequestMortgage() throws Exception {
        MortgageClients mortgageClients = new MortgageClients(0, "Иван",
                "Иванович",
                "Иванов",
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
                "3525422150555",         //notValidINN
                "Выписка из ЕГРН");
        MvcResult result = this.mockMvc.perform(post("/mortgage/create").contentType((MediaType.APPLICATION_JSON))
                .content(objectMapper.writeValueAsString(mortgageClients)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals("Введены не корректные данные.", content);
    }

    @Test
    public void testTryGetAllButGetOne() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/mortgage/get-all"))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        MortgageClients[] mortgageClientsArray = objectMapper.readValue(content, MortgageClients[].class);
        MortgageClients mortgageClient = mortgageClientsArray[0];
        Assert.assertEquals("502805064090", mortgageClient.getInnOfBuyers()); //check valid inn of buyer
    }
}
