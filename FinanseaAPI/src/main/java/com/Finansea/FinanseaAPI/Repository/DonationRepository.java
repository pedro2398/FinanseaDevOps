package com.Finansea.FinanseaAPI.Repository;

import com.Finansea.FinanseaAPI.Model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
}
