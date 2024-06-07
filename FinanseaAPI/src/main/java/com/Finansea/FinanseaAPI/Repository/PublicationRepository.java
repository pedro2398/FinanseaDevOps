package com.Finansea.FinanseaAPI.Repository;

import com.Finansea.FinanseaAPI.Model.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
}
