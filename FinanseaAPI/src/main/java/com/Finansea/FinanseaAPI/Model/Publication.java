package com.Finansea.FinanseaAPI.Model;

import com.Finansea.FinanseaAPI.Model.User.Ong;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PUBLICATION_TB")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PUBLICATION")
    @Column(name = "ID_PUB")
    private Long id;
    @NotBlank
    @Column(name = "DESC_PUB")
    private String description;
    @Column(name = "DATE_PUB")
    public Date date;
    @NotNull
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_ONG", referencedColumnName = "ID")
    private Ong ong;
}
