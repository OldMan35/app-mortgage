package com.example.appmortgage.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "mortgage_clients")
public class MortgageClients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Обязательное для заполнения поле.")
    @Column(name = "name_of_buyers")
    private String nameOfBuyers;

    @NotNull(message = "Обязательное для заполнения поле.")
    @Column(name = "patronymic_of_buyers")
    private String patronymicOfBuyers;

    @NotNull(message = "Обязательное для заполнения поле.")
    @Column(name = "surname_of_buyers")
    private String surnameOfBuyers;

    @NotNull(message = "Обязательное для заполнения поле.")
    @Column(name = "phone_number_of_buyers")
    private long phoneNumberOfBuyers;

    @NotNull(message = "Обязательное для заполнения поле.")
    @Column(name = "loan_amount")
    private String loanAmount;

    @NotNull(message = "Обязательное для заполнения поле.")
    @Column(name = "loan_term")
    private int loanTerm;

    @NotNull(message = "Обязательное для заполнения поле.")
    @Column(name = "estate_object")
    private String estateObject;

    @NotNull(message = "Обязательное для заполнения поле.")
    @Column(name = "cost_object")
    private int costObject;

    @NotNull(message = "Обязательное для заполнения поле.")
    @Column(name = "inn_of_buyers")
    @Size(min = 12, max = 12, message = "Неккоретное значение ИНН.")
    private String innOfBuyers;

    @NotNull(message = "Обязательное для заполнения поле.")
    @Column(name = "name_of_sellers")
    private String nameOfSellers;

    @NotNull(message = "Обязательное для заполнения поле.")
    @Column(name = "patronymic_of_sellers")
    private String patronymicOfSellers;

    @NotNull(message = "Обязательное для заполнения поле.")
    @Column(name = "surname_of_sellers")
    private String surnameOfSellers;

    @NotNull(message = "Обязательное для заполнения поле.")
    @Size(min = 12, max = 12, message = "Неккоретное значение ИНН.")
    @Column(name = "inn_ind")
    private String innInd;

    @NotNull(message = "Обязательное для заполнения поле.")
    @Column(name = "name_organization")
    private String nameOrganization;

    @NotNull(message = "Обязательное для заполнения поле.")
    @Column(name = "inn_org")
    @Size(min = 10, max = 10, message = "Неккоретное значение ИНН.")
    private String innOrg;

    @NotNull(message = "Обязательное для заполнения поле.")
    @Column(name = "own_rights")
    private String ownRights;
}
