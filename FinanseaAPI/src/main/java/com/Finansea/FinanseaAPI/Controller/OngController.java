package com.Finansea.FinanseaAPI.Controller;

import com.Finansea.FinanseaAPI.Model.Dto.OngDTO;
import com.Finansea.FinanseaAPI.Model.User.Ong;
import com.Finansea.FinanseaAPI.Service.OngService;
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
@RequestMapping("ong")
public class OngController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    OngService service;

    @GetMapping
    public ResponseEntity<List<OngDTO>> get(@PageableDefault(size = 3, sort = "id") Pageable pageRequest) {
        log.info("Geting all entities");
        List<OngDTO> entities = service.get(pageRequest).getContent();
        return ResponseEntity.ok(entities);
    }

    @GetMapping("{id}")
    public ResponseEntity<OngDTO> getByID(@PathVariable Long id) {
        log.info("Entity whith id: " + id);
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<OngDTO> post(@RequestBody @Valid Ong entity) {
        log.info("Posting Entity");
        OngDTO newEntity =  service.post(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEntity);
    }

    @PutMapping("{id}")
    public ResponseEntity<OngDTO> put(@PathVariable Long id, @RequestBody @Valid Ong entity) {
        log.info("Changing entity with id: " + id);
        OngDTO newEntity = service.put(id, entity);
        return ResponseEntity.ok(newEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<OngDTO> delete(@PathVariable Long id) {
        log.info("Deleting entity with id: " + id);
        OngDTO entity = service.delete(id);
        return ResponseEntity.ok(entity);
    }
}
