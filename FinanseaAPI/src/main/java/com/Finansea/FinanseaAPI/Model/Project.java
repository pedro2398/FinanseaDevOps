package com.Finansea.FinanseaAPI.Model;

import com.Finansea.FinanseaAPI.Model.User.Ong;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PROJECT_TB")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROJECT")
    @Column(name = "ID_PROJECT")
    private Long id;
    @NotBlank
    @Column(name = "NM_PROJECT")
    private String name;
    @NotBlank
    @Column(name = "ADDRESS_PROJECT")
    private String address;
    @NotBlank
    @Column(name = "DESC_PROJECT")
    private String description;
    @NotNull
    @Column(name = "GOAL_PROJECT")
    private BigDecimal goal;
    @NotBlank
    @Column(name = "STATUS_PROJECT")
    private String status;
    @NotBlank
    @Column(name = "PROOF_PROJECT")
    private String proofOfTheProject;
    @NotNull
    @Column(name = "ACCUMULATED_PROJECT")
    private  BigDecimal accumulated;
    @NotNull
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_ONG", referencedColumnName = "ID")
    private Ong ong;
}
