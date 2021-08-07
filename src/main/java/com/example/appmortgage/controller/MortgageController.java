package com.example.appmortgage.controller;

import com.example.appmortgage.model.MortgageClients;
import com.example.appmortgage.service.MortgageClientsService;
import com.example.appmortgage.service.IndividualInnValidationService;
import com.example.appmortgage.service.OrganizationInnValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@Validated
@RequestMapping(value = "/mortgage")
public class MortgageController extends RuntimeException {

    private final MortgageClientsService mortgageClientsService;
    private final IndividualInnValidationService individualInnValidationService;
    private final OrganizationInnValidationService organizationInnValidationService;

    @Autowired
    public MortgageController(MortgageClientsService mortgageClientsService, IndividualInnValidationService mortgageValidationService, OrganizationInnValidationService organizationInnValidationService) {
        this.mortgageClientsService = mortgageClientsService;
        this.individualInnValidationService = mortgageValidationService;
        this.organizationInnValidationService = organizationInnValidationService;
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
        if (individualInnValidationService.validationInn(mortgageClients.getInnInd()) && individualInnValidationService.validationInn(mortgageClients.getInnOfBuyers()) && organizationInnValidationService.validationInn(mortgageClients.getInnOrg())) {
            mortgageClientsService.create(mortgageClients);
            return new ResponseEntity<>(HttpStatus.valueOf("Заявка создана успешно."));
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
