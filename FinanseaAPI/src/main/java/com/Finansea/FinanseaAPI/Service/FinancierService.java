package com.Finansea.FinanseaAPI.Service;

import com.Finansea.FinanseaAPI.Model.Dto.FinancierDTO;
import com.Finansea.FinanseaAPI.Model.User.Financier;
import com.Finansea.FinanseaAPI.Repository.FinancierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FinancierService {
    @Autowired
    FinancierRepository repository;

    public FinancierDTO getById(Long id) {
        Financier entity = repository.findById(id).orElseThrow( () -> {
            return new RuntimeException("Error when executing request!");
        });
        return new FinancierDTO(entity);
    }

    public Page<FinancierDTO> get(Pageable pageable) {
        Page<Financier> entities = repository.findAll(pageable);
        List<FinancierDTO> entitiesDTO = new ArrayList<>();

        for (Financier entity : entities) {
            entitiesDTO.add(new FinancierDTO(entity));
        }

        Page<FinancierDTO> pageDTO = new PageImpl<>(entitiesDTO);

        return pageDTO;
    }

    public FinancierDTO delete(Long id) {
        FinancierDTO entityDTO = getById(id);
        repository.deleteById(id);
        return entityDTO;
    }

    public FinancierDTO post(Financier entity) {
        repository.save(entity);
        return new FinancierDTO(entity);
    }

    public FinancierDTO put(Long id, Financier entity) {
        getById(id);
        entity.setId(id);
        repository.save(entity);

        return new FinancierDTO(entity);
    }
}
