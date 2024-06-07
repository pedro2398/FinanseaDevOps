package com.Finansea.FinanseaAPI.Model.Dto;

import com.Finansea.FinanseaAPI.Model.User.Financier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancierDTO {
    private long id;
    private String name;
    private String email;
    private String telephone;

    public FinancierDTO(Financier financier) {
        this.id = financier.getId();
        this.name = financier.getName();
        this.email = financier.getEmail();
        this.telephone = financier.getTelephone();
    }
}

