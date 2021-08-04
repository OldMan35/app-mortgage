package com.example.appmortgage.service;

import com.example.appmortgage.repository.SellerIndividualsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerIndividualsService {
    private final SellerIndividualsRepository sellerIndividualsRepository;


}
