package com.example.appmortgage.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NotNull
@Entity
@Table(name = "mortgage_clients")
public class MortgageClients {

    public MortgageClients() {
    }

    public MortgageClients(int id, String nameOfBuyers, String patronymicOfBuyers, String surnameOfBuyers, String phoneNumberOfBuyers, long loanAmount, int loanTerm, String estateObject, long costObject, String innOfBuyers, String nameOfSellers, String patronymicOfSellers, String surnameOfSellers, String innInd, String nameOrganization, String innOrg, String ownRights) {
        this.id = id;
        this.nameOfBuyers = nameOfBuyers;
        this.patronymicOfBuyers = patronymicOfBuyers;
        this.surnameOfBuyers = surnameOfBuyers;
        this.phoneNumberOfBuyers = phoneNumberOfBuyers;
        this.loanAmount = loanAmount;
        this.loanTerm = loanTerm;
        this.estateObject = estateObject;
        this.costObject = costObject;
        this.innOfBuyers = innOfBuyers;
        this.nameOfSellers = nameOfSellers;
        this.patronymicOfSellers = patronymicOfSellers;
        this.surnameOfSellers = surnameOfSellers;
        this.innInd = innInd;
        this.nameOrganization = nameOrganization;
        this.innOrg = innOrg;
        this.ownRights = ownRights;
    }

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
    private String phoneNumberOfBuyers;

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
