package com.Finansea.FinanseaAPI.Controller;

import com.Finansea.FinanseaAPI.Model.Dto.FinancierDTO;
import com.Finansea.FinanseaAPI.Model.User.Financier;
import com.Finansea.FinanseaAPI.Service.FinancierService;
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
@RequestMapping("financier")
public class FinancierController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    FinancierService service;

    @GetMapping
    public ResponseEntity<List<FinancierDTO>> get(@PageableDefault(size = 3, sort = "id") Pageable pageRequest) {
        log.info("Geting all entities");
        List<FinancierDTO> entities = service.get(pageRequest).getContent();
        return ResponseEntity.ok(entities);
    }

    @GetMapping("{id}")
    public ResponseEntity<FinancierDTO> getByID(@PathVariable Long id) {
        log.info("Entity whith id: " + id);
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<FinancierDTO> post(@RequestBody @Valid Financier entity) {
        log.info("Posting Entity");
        FinancierDTO newEntity =  service.post(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEntity);
    }

    @PutMapping("{id}")
    public ResponseEntity<FinancierDTO> put(@PathVariable Long id, @RequestBody @Valid Financier entity) {
        log.info("Changing entity with id: " + id);
        FinancierDTO newEntity = service.put(id, entity);
        return ResponseEntity.ok(newEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<FinancierDTO> delete(@PathVariable Long id) {
        log.info("Deleting entity with id: " + id);
        FinancierDTO entity = service.delete(id);
        return ResponseEntity.ok(entity);
    }
}
