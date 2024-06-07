package com.Finansea.FinanseaAPI.Model.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BANK_ACCOUNT_TB")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_BANK_ACCOUNT")
    @Column(name = "ID_BANCK_ACCOUNT")
    private Long id;
    @NotBlank
    @Column(name = "NUMBER_BANCK_ACCOUNT")
    private String accountNumber;
    @NotBlank
    @Column(name = "AGENCY_BANCK_ACCOUNT")
    private String agency;
    @NotBlank
    @Column(name = "PWD_BANCK_ACCOUNT")
    private String password;
}
