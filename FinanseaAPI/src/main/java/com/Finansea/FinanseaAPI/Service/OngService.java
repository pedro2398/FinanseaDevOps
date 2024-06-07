package com.Finansea.FinanseaAPI.Service;

import com.Finansea.FinanseaAPI.Model.Dto.OngDTO;
import com.Finansea.FinanseaAPI.Model.User.Ong;
import com.Finansea.FinanseaAPI.Repository.OngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OngService {
    @Autowired
    OngRepository repository;

    public OngDTO getById(Long id) {
        Ong entity = repository.findById(id).orElseThrow( () -> {
            return new RuntimeException("Error when executing request!");
        });
        return new OngDTO(entity);
    }

    public Page<OngDTO> get(Pageable pageable) {
        Page<Ong> entities = repository.findAll(pageable);
        List<OngDTO> entitiesDTO = new ArrayList<>();

        for (Ong entity : entities) {
            entitiesDTO.add(new OngDTO(entity));
        }

        Page<OngDTO> pageDTO = new PageImpl<>(entitiesDTO);

        return pageDTO;
    }

    public OngDTO delete(Long id) {
        OngDTO entityDTO = getById(id);
        repository.deleteById(id);
        return entityDTO;
    }

    public OngDTO post(Ong entity) {
        repository.save(entity);
        return new OngDTO(entity);
    }

    public OngDTO put(Long id, Ong entity) {
        getById(id);
        entity.setId(id);
        repository.save(entity);

        return new OngDTO(entity);
    }
}
