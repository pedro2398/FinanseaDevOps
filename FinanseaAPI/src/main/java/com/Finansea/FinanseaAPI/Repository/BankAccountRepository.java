package com.Finansea.FinanseaAPI.Repository;

import com.Finansea.FinanseaAPI.Model.User.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
