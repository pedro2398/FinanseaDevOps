package com.Finansea.FinanseaAPI.Service;

import com.Finansea.FinanseaAPI.Model.Donation;
import com.Finansea.FinanseaAPI.Repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DonationService {
    @Autowired
    DonationRepository repository;

    public Donation getById(Long id) {
        Donation entity = repository.findById(id).orElseThrow( () -> {
            return new RuntimeException("Error when executing request!");
        });
        return entity;
    }

    public Page<Donation> get(Pageable pageable) {
        Page<Donation> entities = repository.findAll(pageable);
        return entities;
    }

    public Donation delete(Long id) {
        Donation entity = getById(id);
        repository.deleteById(id);
        return entity;
    }

    public Donation post(Donation entity) {
        entity.setDate(new Date());
        repository.save(entity);
        return entity;
    }

    public Donation put(Long id, Donation entity) {
        getById(id);
        entity.setId(id);
        repository.save(entity);

        return entity;
    }
}
