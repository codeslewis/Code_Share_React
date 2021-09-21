package io.lewiscodes.codesharereact.controllers;

import io.lewiscodes.codesharereact.models.Recipe;
import io.lewiscodes.codesharereact.services.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
