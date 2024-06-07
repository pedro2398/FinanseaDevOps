package com.Finansea.FinanseaAPI.Controller;

import com.Finansea.FinanseaAPI.Model.Project;
import com.Finansea.FinanseaAPI.Service.ProjectService;
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
@RequestMapping("project")
public class ProjectController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ProjectService service;

    @GetMapping
    public ResponseEntity<List<Project>> get(@PageableDefault(size = 3, sort = "id") Pageable pageRequest) {
        log.info("Geting all entities");
        List<Project> entities = service.get(pageRequest).getContent();
        return ResponseEntity.ok(entities);
    }

    @GetMapping("{id}")
    public ResponseEntity<Project> getByID(@PathVariable Long id) {
        log.info("Entity whith id: " + id);
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Project> post(@RequestBody @Valid Project entity) {
        log.info("Posting Entity");
        Project newEntity =  service.post(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEntity);
    }

    @PutMapping("{id}")
    public ResponseEntity<Project> put(@PathVariable Long id, @RequestBody @Valid Project entity) {
        log.info("Changing entity with id: " + id);
        Project newEntity = service.put(id, entity);
        return ResponseEntity.ok(newEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Project> delete(@PathVariable Long id) {
        log.info("Deleting entity with id: " + id);
        Project entity = service.delete(id);
        return ResponseEntity.ok(entity);
    }
}
