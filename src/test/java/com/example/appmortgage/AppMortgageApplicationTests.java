package com.example.appmortgage;


import com.example.appmortgage.controller.MortgageController;
import com.example.appmortgage.model.MortgageClients;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
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
        MortgageClients mortgageClients = MortgageClients.builder()
                .id(0)
                .nameOfBuyers(null)                   //null
                .patronymicOfBuyers("Васильевич")
                .surnameOfBuyers(null)                //null
                .phoneNumberOfBuyers("89116665533")
                .loanAmount(1500000)
                .loanTerm(5)
                .estateObject("квартира")
                .costObject(2000000)
                .innOfBuyers("502805064090")
                .nameOfSellers("Михаил")
                .patronymicOfSellers("Михайлович")
                .surnameOfSellers("Михайлов")
                .innInd("502805064090f")              //not valid inn
                .nameOrganization("ООО Рога и копыта")
                .innOrg("3525422150fff")              //not valid inn
                .ownRights("Выписка из ЕГРН")
                .build();
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
