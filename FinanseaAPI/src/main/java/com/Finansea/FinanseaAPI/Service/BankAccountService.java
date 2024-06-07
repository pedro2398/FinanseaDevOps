package com.Finansea.FinanseaAPI.Service;

import com.Finansea.FinanseaAPI.Model.Dto.BankAccountDTO;
import com.Finansea.FinanseaAPI.Repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.Finansea.FinanseaAPI.Model.User.BankAccount;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {
    @Autowired
    BankAccountRepository repository;

    public BankAccountDTO getById(Long id) {
        BankAccount entity = repository.findById(id).orElseThrow( () -> {
            return new RuntimeException("Error when executing request!");
        });
        return new BankAccountDTO(entity);
    }

    public Page<BankAccountDTO> get(Pageable pageable) {
        Page<BankAccount> entities = repository.findAll(pageable);
        List<BankAccountDTO> entitiesDTO = new ArrayList<>();

        for (BankAccount entity : entities) {
            entitiesDTO.add(new BankAccountDTO(entity));
        }

        Page<BankAccountDTO> pageDTO = new PageImpl<>(entitiesDTO);

        return pageDTO;
    }

    public BankAccountDTO delete(Long id) {
        BankAccountDTO entityDTO = getById(id);
        repository.deleteById(id);
        return entityDTO;
    }

    public BankAccountDTO post(BankAccount entity) {
        repository.save(entity);
        return new BankAccountDTO(entity);
    }

    public BankAccountDTO put(Long id, BankAccount entity) {
        getById(id);
        entity.setId(id);
        repository.save(entity);

        return new BankAccountDTO(entity);
    }
}
