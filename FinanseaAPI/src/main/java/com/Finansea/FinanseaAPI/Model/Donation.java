package com.Finansea.FinanseaAPI.Model;

import com.Finansea.FinanseaAPI.Model.User.Financier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DONATION_TB")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DONATION")
    @Column(name = "ID_DONATION")
    private Long id;
    @NotNull
    @Column(name = "AMOUNT_DONATION")
    private BigDecimal amount;
    @Column(name = "DATE_DONATION")
    private Date date;
    @NotNull
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_PROJECT", referencedColumnName = "ID_PROJECT")
    private Project project;
    @NotNull
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_FINANCIER", referencedColumnName = "ID")
    private Financier donor;
}
