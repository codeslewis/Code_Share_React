package io.lewiscodes.codesharereact.services;

import io.lewiscodes.codesharereact.controllers.ApiController;
import io.lewiscodes.codesharereact.controllers.RecipeController;
import io.lewiscodes.codesharereact.exceptions.SnippetNotFoundException;
import io.lewiscodes.codesharereact.models.Recipe;
import io.lewiscodes.codesharereact.models.RecipeModelAssembler;
import io.lewiscodes.codesharereact.models.Snippet;
import io.lewiscodes.codesharereact.models.SnippetModelAssembler;
import io.lewiscodes.codesharereact.repositories.RecipeRepository;
import io.lewiscodes.codesharereact.repositories.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class SnippetService implements CodeService {
    private final SnippetRepository snippetRepository;
    private final RecipeRepository recipeRepository;
    private final SnippetModelAssembler assembler;
    private final RecipeModelAssembler recipeAssembler;

    @Autowired
    public SnippetService(
            SnippetRepository snippetRepository,
            SnippetModelAssembler assembler,
            RecipeRepository recipeRepository,
            RecipeModelAssembler recipeAssembler
    ) {
        this.snippetRepository = snippetRepository;
        this.assembler = assembler;
        this.recipeRepository = recipeRepository;
        this.recipeAssembler = recipeAssembler;
    }

    @Override
    public ResponseEntity<?> addSnippet(Snippet snippet) {
        EntityModel<Snippet> entityModel = assembler.toModel(snippetRepository.save(snippet));
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @Override
    public ResponseEntity<?> addRecipe(Recipe recipe) {
        EntityModel<Recipe> entityModel = recipeAssembler.toModel(recipeRepository.save(recipe));
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @Override
    public EntityModel<Snippet> getSnippet(long index) {
        Snippet snippet = snippetRepository
                .findById(index)
                .orElseThrow(SnippetNotFoundException::new);
        return assembler.toModel(snippet);
    }

    @Override
    public EntityModel<Recipe> getRecipe(long index) {
        Recipe recipe = recipeRepository
                .findById(index)
                .orElseThrow(SnippetNotFoundException::new);
        return recipeAssembler.toModel(recipe);
    }

    @Override
    public CollectionModel<EntityModel<Snippet>> getLatest() {
        List<EntityModel<Snippet>> latest = snippetRepository
                .findAll()
                .stream()
                .sorted()
                .limit(10)
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(latest, linkTo(methodOn(ApiController.class).getLatestCode()).withSelfRel());
    }

    @Override
    public CollectionModel<EntityModel<Snippet>> allByLang(String lang) {
        List<EntityModel<Snippet>> byLang = snippetRepository
                .findAll()
                .parallelStream()
                .filter(snippet -> snippet.getLang().equals(lang))
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(byLang, linkTo(methodOn(ApiController.class).getAllByLang(lang)).withSelfRel());
    }

    @Override
    public CollectionModel<EntityModel<Recipe>> getAllRecipes() {
        List<EntityModel<Recipe>> allRecipes = recipeRepository
                .findAll()
                .stream()
                .map(recipeAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(allRecipes, linkTo(methodOn(RecipeController.class).all()).withSelfRel());
    }

    @Override
    public CollectionModel<EntityModel<Snippet>> latestByLang(String lang) {
        List<EntityModel<Snippet>> byLang = snippetRepository
                .findAll()
                .stream()
                .filter(snippet -> snippet.getLang().equals(lang))
                .sorted()
                .limit(10)
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(byLang, linkTo(methodOn(ApiController.class).getLatestByLang(lang)).withSelfRel());
    }

    @Override
    public ResponseEntity<?> drop() {
        snippetRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
