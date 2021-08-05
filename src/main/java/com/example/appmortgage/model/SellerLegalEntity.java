package com.example.appmortgage.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "Seller_Legal_Entity")
public class SellerLegalEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BUYER_ID", insertable = false, updatable = false)
    private Buyer buyer;

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty(message = "Обязательное для заполнения поле.")
    @Column(name = "name_organization")
    private String nameOrganization;

    @NotEmpty(message = "Обязательное для заполнения поле.")
    @Column(name = "phone_number")
    @Size(min = 11, max = 12, message = "Неккоректно введен номер телефона.")
    private String phoneNumber;

    @NotEmpty(message = "Обязательное для заполнения поле.")
    @Column(name = "ownership_rights")
    private String ownershipRights;

    @Column(name = "BUYER_ID")
    private int buyerIdLe;

    @NotEmpty(message = "Обязательное для заполнения поле.")
    @Column(name = "inn", unique = true, nullable = false)
    @Min(value = 12, message = "Неккоретное значение ИНН.")
    @Max(value = 12, message = "Неккоретное значение ИНН.")
    private int inn;
}
