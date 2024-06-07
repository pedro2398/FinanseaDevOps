package com.Finansea.FinanseaAPI.Service;

import com.Finansea.FinanseaAPI.Model.Project;
import com.Finansea.FinanseaAPI.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository repository;

    public Project getById(Long id) {
        Project entity = repository.findById(id).orElseThrow( () -> {
            return new RuntimeException("Error when executing request!");
        });
        return entity;
    }

    public Page<Project> get(Pageable pageable) {
        Page<Project> entities = repository.findAll(pageable);
        return entities;
    }

    public Project delete(Long id) {
        Project entity = getById(id);
        repository.deleteById(id);
        return entity;
    }

    public Project post(Project entity) {
        repository.save(entity);
        return entity;
    }

    public Project put(Long id, Project entity) {
        getById(id);
        entity.setId(id);
        repository.save(entity);

        return entity;
    }
}
