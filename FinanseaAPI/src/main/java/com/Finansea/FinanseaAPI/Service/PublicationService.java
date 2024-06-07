package com.Finansea.FinanseaAPI.Service;

import com.Finansea.FinanseaAPI.Model.Publication;
import com.Finansea.FinanseaAPI.Repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.security.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Service
public class PublicationService {
    @Autowired
    PublicationRepository repository;

    public Publication getById(Long id) {
        Publication entity = repository.findById(id).orElseThrow( () -> {
            return new RuntimeException("Error when executing request!");
        });
        return entity;
    }

    public Page<Publication> get(Pageable pageable) {
        Page<Publication> entities = repository.findAll(pageable);
        return entities;
    }

    public Publication delete(Long id) {
        Publication entity = getById(id);
        repository.deleteById(id);
        return entity;
    }

    public Publication post(Publication entity) {
        entity.setDate(new Date());
        repository.save(entity);
        return entity;
    }

    public Publication put(Long id, Publication entity) {
        getById(id);
        entity.setId(id);
        repository.save(entity);

        return entity;
    }
}
