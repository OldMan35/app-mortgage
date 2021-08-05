package com.example.appmortgage.controller;

import com.example.appmortgage.model.Buyer;
import com.example.appmortgage.model.SellerIndividuals;
import com.example.appmortgage.service.BuyerService;
import com.example.appmortgage.service.SellerIndividualsService;
import com.example.appmortgage.service.SellerLegalEntityService;
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

    private BuyerService buyerService;
    private SellerIndividualsService sellerIndividualsService;
    private SellerLegalEntityService sellerLegalEntityService;

    @Autowired
    public DefaultController(BuyerService buyerService, SellerIndividualsService sellerIndividualsService, SellerLegalEntityService sellerLegalEntityService) {
        this.buyerService = buyerService;
        this.sellerIndividualsService = sellerIndividualsService;
        this.sellerLegalEntityService = sellerLegalEntityService;
    }

    @GetMapping("/buyers")
    public ResponseEntity<List<Buyer>> findAll() {
        final List<Buyer> buyers = buyerService.findAll();
        return buyers != null || !buyers.isEmpty()
                ? new ResponseEntity<>(buyers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/sellers_individuals")
    public ResponseEntity<List<SellerIndividuals>> findAllSellersIndividuals() {
        final List<SellerIndividuals> sellersIndividuals = sellerIndividualsService.findAll();
        return sellersIndividuals != null || !sellersIndividuals.isEmpty()
                ? new ResponseEntity<>(sellersIndividuals, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/buyers")
    public ResponseEntity<?> create(@RequestBody Buyer buyer) {
        buyerService.create(buyer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
