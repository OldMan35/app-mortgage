package com.example.appmortgage.model;


import com.example.appmortgage.validation.InnValidation;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mortgage_clients")
public class MortgageClients {

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
