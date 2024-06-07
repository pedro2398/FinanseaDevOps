package com.Finansea.FinanseaAPI.Repository;

import com.Finansea.FinanseaAPI.Model.User.Financier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancierRepository extends JpaRepository<Financier,Long> {
}
