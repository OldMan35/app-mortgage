package com.example.appmortgage.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "mortgage_clients")
public class MortgageClients {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_of_buyers")
    private String nameOfBuyers;

    @Column(name = "patronymic_of_buyers")
    private String patronymicOfBuyers;

    @Column(name = "surname_of_buyers")
    private String surnameOfBuyers;

    @Column(name = "phone_number_of_buyers")
    private long phoneNumberOfBuyers;

    @Column(name = "loan_amount")
    private long loanAmount;

    @Column(name = "loan_term")
    private int loanTerm;

    @Column(name = "estate_object")
    private String estateObject;

    @Column(name = "cost_object")
    private long costObject;

    @Column(name = "inn_of_buyers")
    private String innOfBuyers;

    @Column(name = "name_of_sellers")
    private String nameOfSellers;

    @Column(name = "patronymic_of_sellers")
    private String patronymicOfSellers;

    @Column(name = "surname_of_sellers")
    private String surnameOfSellers;

    @Column(name = "inn_ind")
    private String innInd;

    @Column(name = "name_organization")
    private String nameOrganization;

    @Column(name = "inn_org")
    private String innOrg;

    @Column(name = "own_rights")
    private String ownRights;
}
