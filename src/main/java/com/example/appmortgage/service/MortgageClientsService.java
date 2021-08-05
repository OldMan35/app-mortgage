package com.example.appmortgage.service;

import com.example.appmortgage.model.MortgageClients;
import com.example.appmortgage.repository.MortgageClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MortgageClientsService {

    private MortgageClientsRepository mortgageClientsRepository;

    @Autowired
    public MortgageClientsService(MortgageClientsRepository mortgageClientsRepository) {
        this.mortgageClientsRepository = mortgageClientsRepository;
    }

    public List<MortgageClients> findAll() {
        return mortgageClientsRepository.findAll();
    }

    public MortgageClients create(MortgageClients mortgageClients) {
        return mortgageClientsRepository.save(mortgageClients);
    }
}
