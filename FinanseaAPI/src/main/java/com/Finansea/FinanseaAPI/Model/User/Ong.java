package com.Finansea.FinanseaAPI.Model.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "ONG_TB")
@DiscriminatorValue("ONG")
public class Ong {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ONG")
    @Column(name = "ID")
    private Long id;
    @NotBlank
    @Column(name = "DOCUMENT")
    private String document;
    @NotBlank
    @Column(name = "NM")
    private String name;
    @Email
    @NotBlank
    @Column(name = "EMAIL")
    private String email;
    @NotBlank
    @Column(name = "PWD")
    private String password;
    @NotBlank
    @Column(name = "ADDRESS")
    private String address;
    @NotBlank
    @Column(name = "PHONE")
    private String telephone;
    @NotNull
    @OneToOne(cascade =  CascadeType.MERGE )
    @JoinColumn(name = "ID_BANK_ACCOUNT", referencedColumnName = "ID_BANCK_ACCOUNT")
    private BankAccount bankData;
}
