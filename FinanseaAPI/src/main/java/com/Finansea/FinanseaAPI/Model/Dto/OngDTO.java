package com.Finansea.FinanseaAPI.Model.Dto;

import com.Finansea.FinanseaAPI.Model.User.Ong;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OngDTO {
    private long id;
    private String name;
    private String email;
    private String telephone;

    public OngDTO(Ong ong) {
        this.id = ong.getId();
        this.name = ong.getName();
        this.email = ong.getEmail();
        this.telephone = ong.getTelephone();
    }
}
