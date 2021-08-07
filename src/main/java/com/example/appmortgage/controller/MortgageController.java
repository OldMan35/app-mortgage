package com.example.appmortgage.controller;

import com.example.appmortgage.model.MortgageClients;
import com.example.appmortgage.service.MortgageClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/mortgage")
public class MortgageController {

    private final MortgageClientsService mortgageClientsService;

    @Autowired
    public MortgageController(MortgageClientsService mortgageClientsService) {
        this.mortgageClientsService = mortgageClientsService;
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<MortgageClients>> getAll() {
        List<MortgageClients> mortgageClientsList = mortgageClientsService.findAll();
        return mortgageClientsList != null && !mortgageClientsList.isEmpty()
                ? new ResponseEntity<>(mortgageClientsList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createMortgageClients(@RequestBody MortgageClients mortgageClients) {
        mortgageClientsService.create(mortgageClients);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
