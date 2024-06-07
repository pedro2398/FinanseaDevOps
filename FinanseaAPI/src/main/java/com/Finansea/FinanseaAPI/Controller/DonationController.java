package com.Finansea.FinanseaAPI.Controller;

import com.Finansea.FinanseaAPI.Model.Donation;
import com.Finansea.FinanseaAPI.Service.DonationService;
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
@RequestMapping("donation")
public class DonationController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    DonationService service;

    @GetMapping()
    public ResponseEntity<List<Donation>> get(@PageableDefault(size = 3, sort = "id") Pageable pageRequest) {
        log.info("Geting all entities");
        List<Donation> entities = service.get(pageRequest).getContent();
        return ResponseEntity.ok(entities);
    }

    @GetMapping("{id}")
    public ResponseEntity<Donation> getByID(@PathVariable Long id) {
        log.info("Entity whith id: " + id);
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Donation> post(@RequestBody @Valid Donation entity) {
        log.info("Posting Entity");
        Donation newEntity =  service.post(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEntity);
    }

    @PutMapping("{id}")
    public ResponseEntity<Donation> put(@PathVariable Long id, @RequestBody @Valid Donation entity) {
        log.info("Changing entity with id: " + id);
        Donation newEntity = service.put(id, entity);
        return ResponseEntity.ok(newEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Donation> delete(@PathVariable Long id) {
        log.info("Deleting entity with id: " + id);
        Donation entity = service.delete(id);
        return ResponseEntity.ok(entity);
    }
}
