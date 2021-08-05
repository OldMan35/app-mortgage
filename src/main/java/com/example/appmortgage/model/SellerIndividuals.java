package com.example.appmortgage.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "Seller_Individuals")
public class SellerIndividuals {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty(message = "Обязательное для заполнения поле.")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Обязательное для заполнения поле.")
    @Column(name = "patronymic")
    private String patronymic;

    @NotEmpty(message = "Обязательное для заполнения поле.")
    @Column(name = "surname")
    private String surname;

    @NotEmpty(message = "Обязательное для заполнения поле.")
    @Column(name = "phone_number")
    @Size(min = 11, max = 12, message = "Неккоректно введен номер телефона.")
    private String phoneNumber;

    @NotEmpty(message = "Обязательное для заполнения поле.")
    @Column(name = "ownership_rights")
    private String ownershipRights;

    @Column(name = "buyer_id")
    private int buyerId;

    @NotEmpty(message = "Обязательное для заполнения поле.")
    @Column(name = "inn", unique = true, nullable = false)
    @Min(value = 12, message = "Неккоретное значение ИНН.")
    @Max(value = 12, message = "Неккоретное значение ИНН.")
    private int inn;
}
