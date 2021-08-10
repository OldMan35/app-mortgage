package com.example.appmortgage.controller;

import com.example.appmortgage.model.MortgageClients;
import com.example.appmortgage.service.InnValidationService;
import com.example.appmortgage.service.MortgageClientsService;
import com.example.appmortgage.service.IndividualInnValidationService;
import com.example.appmortgage.service.OrganizationInnValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Validated
@RequestMapping(value = "/mortgage")
public class MortgageController {

    private final MortgageClientsService mortgageClientsService;
    private final IndividualInnValidationService individualInnValidationService;//
    private final OrganizationInnValidationService organizationInnValidationService;//
    private final InnValidationService innValidationService;

    @Autowired
    public MortgageController(MortgageClientsService mortgageClientsService, IndividualInnValidationService mortgageValidationService, OrganizationInnValidationService organizationInnValidationService, InnValidationService innValidationService) {
        this.mortgageClientsService = mortgageClientsService;
        this.individualInnValidationService = mortgageValidationService;
        this.organizationInnValidationService = organizationInnValidationService;
        this.innValidationService = innValidationService;
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<?> getAll() {
        List<MortgageClients> mortgageClientsList = mortgageClientsService.getAll();
        if (mortgageClientsList.size() != 0) {
            return ResponseEntity.ok().body(mortgageClientsList);
        } else {
            return new ResponseEntity<>("Заявок нет.", HttpStatus.OK);
        }

    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createMortgageClients(@RequestBody MortgageClients mortgageClients) {
        if (innValidationService.isValid(mortgageClients.getInnInd(), massage) && individualInnValidationService.validationInn(mortgageClients.getInnOfBuyers()) && organizationInnValidationService.validationInn(mortgageClients.getInnOrg())) {
            mortgageClientsService.create(mortgageClients);
            return new ResponseEntity<>("Заявка создана.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Введены не корректные данные.", HttpStatus.BAD_REQUEST);
        }
    }

}
