package com.example.appmortgage.service;

import com.example.appmortgage.repository.SellerLegalEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerLegalEntityService {
    private final SellerLegalEntityRepository sellerLegalEntityRepository;
}
