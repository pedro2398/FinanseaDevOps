package com.Finansea.FinanseaAPI.Controller;

import com.Finansea.FinanseaAPI.Model.Publication;
import com.Finansea.FinanseaAPI.Service.PublicationService;
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
@RequestMapping("publication")
public class PublicationController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    PublicationService service;

    @GetMapping
    public ResponseEntity<List<Publication>> get(@PageableDefault(size = 3, sort = "id") Pageable pageRequest) {
        log.info("Geting all entities");
        List<Publication> entities = service.get(pageRequest).getContent();
        return ResponseEntity.ok(entities);
    }

    @GetMapping("{id}")
    public ResponseEntity<Publication> getByID(@PathVariable Long id) {
        log.info("Entity whith id: " + id);
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Publication> post(@RequestBody @Valid Publication entity) {
        log.info("Posting Entity");
        Publication newEntity =  service.post(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEntity);
    }

    @PutMapping("{id}")
    public ResponseEntity<Publication> put(@PathVariable Long id, @RequestBody @Valid Publication entity) {
        log.info("Changing entity with id: " + id);
        Publication newEntity = service.put(id, entity);
        return ResponseEntity.ok(newEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Publication> delete(@PathVariable Long id) {
        log.info("Deleting entity with id: " + id);
        Publication entity = service.delete(id);
        return ResponseEntity.ok(entity);
    }
}
