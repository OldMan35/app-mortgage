package com.example.appmortgage.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "Buyer")
public class Buyer {

    @OneToOne
    @JoinColumn
    private SellerIndividuals sellerIndividuals;


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
    @Column(name = "loan_amount")
    private String loanAmount;

    @NotEmpty(message = "Обязательное для заполнения поле.")
    @Column(name = "loan_term")
    @Min(value = 3, message = "Неккоретное значение. Срок кредита не может быть менее 3 лет.")
    @Max(value = 30, message = "Неккоретное значение. Срок кредита не может быть более 30 лет")
    private int loanTerm;

    @NotEmpty(message = "Обязательное для заполнения поле.")
    @Column(name = "estate_object")
    private String estateObject;

    @NotEmpty(message = "Обязательное для заполнения поле.")
    @Column(name = "cost_object")
    private int costObject;

    @NotEmpty(message = "Обязательное для заполнения поле.")
    @Column(name = "inn")
    @Min(value = 12, message = "Неккоретное значение ИНН.")
    @Max(value = 12, message = "Неккоретное значение ИНН.")
    private int inn;
}
