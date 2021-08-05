package com.example.appmortgage.controller;

import com.example.appmortgage.model.MortgageClients;
import com.example.appmortgage.service.MortgageClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DefaultController {

    private MortgageClientsService mortgageClientsService;

    @Autowired
    public DefaultController(MortgageClientsService mortgageClientsService) {
        this.mortgageClientsService = mortgageClientsService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<MortgageClients>> findAll() {
        List<MortgageClients> mortgageClientsList = mortgageClientsService.findAll();
        return mortgageClientsList != null && !mortgageClientsList.isEmpty()
                ? new ResponseEntity<>(mortgageClientsList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> createMortgageClients(@RequestBody MortgageClients mortgageClients) {
        mortgageClientsService.create(mortgageClients);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
