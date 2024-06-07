package com.Finansea.FinanseaAPI.Controller;

import com.Finansea.FinanseaAPI.Model.Dto.BankAccountDTO;
import com.Finansea.FinanseaAPI.Model.User.BankAccount;
import com.Finansea.FinanseaAPI.Service.BankAccountService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("bank_account")
public class BankAccountController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    BankAccountService service;

    @GetMapping
    public List<BankAccountDTO> get(@PageableDefault(size = 3, sort = "id") Pageable pageRequest) {
        log.info("Geting all entities");
        List<BankAccountDTO> entities = service.get(pageRequest).getContent();
        return entities;
    }

    @GetMapping("{id}")
    public ResponseEntity<BankAccountDTO> getByID(@PathVariable Long id) {
        log.info("Entity whith id: " + id);
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<BankAccountDTO> post(@RequestBody @Valid BankAccount entity) {
        log.info("Posting Entity");
        BankAccountDTO newEntity =  service.post(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEntity);
    }

    @PutMapping("{id}")
    public ResponseEntity<BankAccountDTO> put(@PathVariable Long id, @RequestBody @Valid BankAccount entity) {
        log.info("Changing entity with id: " + id);
        BankAccountDTO newEntity = service.put(id, entity);
        return ResponseEntity.ok(newEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BankAccountDTO> delete(@PathVariable Long id) {
        log.info("Deleting entity with id: " + id);
        BankAccountDTO entity = service.delete(id);
        return ResponseEntity.ok(entity);
    }
}
