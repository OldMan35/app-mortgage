package com.example.appmortgage.model;


import com.example.appmortgage.repository.InnValidation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
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

    @NotNull
    @Column(name = "name_of_buyers")
    private String nameOfBuyers;

    @NotNull
    @Column(name = "patronymic_of_buyers")
    private String patronymicOfBuyers;

    @NotNull
    @Column(name = "surname_of_buyers")
    private String surnameOfBuyers;

    @NotNull
    @Column(name = "phone_number_of_buyers")
    private String phoneNumberOfBuyers;

    @NotNull
    @Column(name = "loan_amount")
    private long loanAmount;

    @NotNull
    @Column(name = "loan_term")
    private int loanTerm;

    @NotNull
    @Column(name = "estate_object")
    private String estateObject;

    @NotNull
    @Column(name = "cost_object")
    private long costObject;

    @NotNull
    @InnValidation
    @Column(name = "inn_of_buyers")
    private String innOfBuyers;

    @NotNull
    @Column(name = "name_of_sellers")
    private String nameOfSellers;

    @NotNull
    @Column(name = "patronymic_of_sellers")
    private String patronymicOfSellers;

    @NotNull
    @Column(name = "surname_of_sellers")
    private String surnameOfSellers;

    @NotNull
    @Column(name = "inn_ind")
    @InnValidation
    private String innInd;

    @NotNull
    @Column(name = "name_organization")
    private String nameOrganization;

    @NotNull
    @Column(name = "inn_org")
    @InnValidation
    private String innOrg;

    @NotNull
    @Column(name = "own_rights")
    private String ownRights;
}
