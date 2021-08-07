package com.example.appmortgage.controller;

import com.example.appmortgage.model.MortgageClients;
import com.example.appmortgage.service.MortgageClientsService;
import com.example.appmortgage.service.MortgageValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/mortgage")
public class MortgageController extends RuntimeException {

    private final MortgageClientsService mortgageClientsService;
    private final MortgageValidationService mortgageValidationService;
    private final Exception exception = new Exception("Некорректно введен ИНН.");

    @Autowired
    public MortgageController(MortgageClientsService mortgageClientsService, MortgageValidationService mortgageValidationService) {
        this.mortgageClientsService = mortgageClientsService;
        this.mortgageValidationService = mortgageValidationService;
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
        if (MortgageValidationService.validationInn(mortgageClients.getInnInd(), mortgageClients.getInnOrg())) {
            mortgageClientsService.create(mortgageClients);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            String validationException = exception.getMessage();
            return new ResponseEntity<>(HttpStatus.valueOf(validationException));
        }
    }

}
