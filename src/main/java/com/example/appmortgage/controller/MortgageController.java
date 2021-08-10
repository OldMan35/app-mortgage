package com.example.appmortgage.controller;

import com.example.appmortgage.model.MortgageClients;
import com.example.appmortgage.service.MortgageClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;


@RestController
@Validated
@RequestMapping(value = "/mortgage")
public class MortgageController {

    private final MortgageClientsService mortgageClientsService;


    @Autowired
    public MortgageController(MortgageClientsService mortgageClientsService) {
        this.mortgageClientsService = mortgageClientsService;
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<?> getAll() {
        List<MortgageClients> mortgageClientsList = mortgageClientsService.getAll();
        if (mortgageClientsList.size() != 0) {
            return ResponseEntity.ok().body(mortgageClientsList);
        } else {
            return new ResponseEntity<>("Заявок нет", HttpStatus.OK);
        }

    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createMortgageClients(@Valid @RequestBody MortgageClients mortgageClients, BindingResult result) {
        if (result.hasFieldErrors()) {
            throw new ValidationException("Некорректные данные");
        } else {
            mortgageClientsService.create(mortgageClients);
            return new ResponseEntity<>("Заявка создана", HttpStatus.CREATED);
        }
    }

    @ControllerAdvice
    public class ExceptionHelper {
        @ExceptionHandler(value = {ValidationException.class})
        public ResponseEntity<Object> handleInvalidInputException(Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
