package io.lewiscodes.codesharereact.controllers;

import io.lewiscodes.codesharereact.models.Snippet;
import io.lewiscodes.codesharereact.services.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {
    CodeService snippetService;

    public ApiController(
            @Autowired CodeService snippetService
    ) {
        this.snippetService = snippetService;
    }

    @GetMapping("/api/code/{id}")
    public EntityModel<Snippet> getCode(@PathVariable long id) {
        return snippetService.getSnippet(id);
    }

    @GetMapping("/api/code/latest")
    public CollectionModel<EntityModel<Snippet>> getLatestCode() {
        return snippetService.getLatest();
    }

    @GetMapping("/api/code/latest/{lang}")
    public CollectionModel<EntityModel<Snippet>> getLatestByLang(@PathVariable String lang) {
        return snippetService.latestByLang(lang);
    }

    @GetMapping("api/code/all/{lang}")
    public CollectionModel<EntityModel<Snippet>> getAllByLang(@PathVariable String lang) {
        return snippetService.allByLang(lang);
    }

    @PostMapping(path = "api/code/new", consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody Snippet code) {
        return snippetService.addSnippet(code);
    }

    @DeleteMapping("api/code/droptable")
    public ResponseEntity<?> dropTable() {
        return snippetService.drop();
    }
}
