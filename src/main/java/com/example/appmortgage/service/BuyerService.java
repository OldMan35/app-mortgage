package com.example.appmortgage.service;

import com.example.appmortgage.repository.BuyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuyerService {
    private final BuyerRepository buyerRepository;
    private final List<String> estateObjectForChoiceBuyer = Arrays.asList("Квартира в новостройке",
            "Квартира на вторичном рынке", "Дом в деревне", "Земельный участок",
            "Коммерческая недвижимость");

}
