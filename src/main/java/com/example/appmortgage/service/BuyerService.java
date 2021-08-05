package com.example.appmortgage.service;

import com.example.appmortgage.model.Buyer;
import com.example.appmortgage.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {

    private BuyerRepository buyerRepository;

    @Autowired
    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public List<Buyer> findAll() {
        return buyerRepository.findAll();
    }

    public Buyer create(Buyer buyer) {
        return buyerRepository.save(buyer);
    }
}
