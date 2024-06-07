package com.Finansea.FinanseaAPI.Model.Dto;

import com.Finansea.FinanseaAPI.Model.User.BankAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDTO {

    private long id;
    private String accountNumber;
    private String agency;

    public BankAccountDTO(BankAccount bankAccount) {
        this.id = bankAccount.getId();
        this.accountNumber = bankAccount.getAccountNumber();
        this.agency = bankAccount.getAgency();
    }
}

