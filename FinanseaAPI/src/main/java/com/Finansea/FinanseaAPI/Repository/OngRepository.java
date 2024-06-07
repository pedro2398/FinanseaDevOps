package com.Finansea.FinanseaAPI.Repository;

import com.Finansea.FinanseaAPI.Model.User.Ong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OngRepository extends JpaRepository<Ong, Long> {
}
