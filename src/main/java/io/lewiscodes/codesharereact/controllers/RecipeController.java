package io.lewiscodes.codesharereact.controllers;

import io.lewiscodes.codesharereact.models.Recipe;
import io.lewiscodes.codesharereact.services.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipeController {
    private final CodeService snippetService;

    @Autowired
    public RecipeController(CodeService snippetService) {
        this.snippetService = snippetService;
    }

    @GetMapping("/api/recipes/all")
    public CollectionModel<EntityModel<Recipe>> all() {
        return snippetService.getAllRecipes();
    }

    @GetMapping("/api/recipes/{id}")
    public EntityModel<Recipe> getRecipe(@PathVariable long id) {
        return snippetService.getRecipe(id);
    }

    @PostMapping(path = "/api/recipes/new", consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody Recipe recipe) {
        return snippetService.addRecipe(recipe);
    }
}
