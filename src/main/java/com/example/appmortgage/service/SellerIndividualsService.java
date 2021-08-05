package com.example.appmortgage.service;

import com.example.appmortgage.model.Buyer;
import com.example.appmortgage.model.SellerIndividuals;
import com.example.appmortgage.repository.SellerIndividualsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerIndividualsService {

    private SellerIndividualsRepository sellerIndividualsRepository;

    @Autowired
    public SellerIndividualsService(SellerIndividualsRepository sellerIndividualsRepository) {
        this.sellerIndividualsRepository = sellerIndividualsRepository;
    }

    public List<SellerIndividuals> findAll() {
        return sellerIndividualsRepository.findAll();
    }

    public SellerIndividuals create(SellerIndividuals sellerIndividuals) {
        return sellerIndividualsRepository.save(sellerIndividuals);
    }
}
