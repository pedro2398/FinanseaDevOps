package com.Finansea.FinanseaAPI.Repository;

import com.Finansea.FinanseaAPI.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
