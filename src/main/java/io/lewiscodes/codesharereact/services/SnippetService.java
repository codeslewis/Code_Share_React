package io.lewiscodes.codesharereact.services;

import io.lewiscodes.codesharereact.controllers.CodeController;
import io.lewiscodes.codesharereact.controllers.RecipeController;
import io.lewiscodes.codesharereact.exceptions.EntityNotFoundException;
import io.lewiscodes.codesharereact.models.*;
import io.lewiscodes.codesharereact.repositories.RecipeRepository;
import io.lewiscodes.codesharereact.repositories.SnippetRepository;
import io.lewiscodes.codesharereact.repositories.UserRepository;
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
    private final UserRepository userRepository;
    private final UserModelAssembler userAssembler;

    @Autowired
    public SnippetService(
            SnippetRepository snippetRepository,
            SnippetModelAssembler assembler,
            RecipeRepository recipeRepository,
            RecipeModelAssembler recipeAssembler,
            UserRepository userRepository,
            UserModelAssembler userAssembler
    ) {
        this.snippetRepository = snippetRepository;
        this.assembler = assembler;
        this.recipeRepository = recipeRepository;
        this.recipeAssembler = recipeAssembler;
        this.userRepository = userRepository;
        this.userAssembler = userAssembler;
    }

    @Override
    public ResponseEntity<?> addSnippet(Snippet snippet, long recipeId, long userId) {
//        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(EntityNotFoundException::new);
//        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
//        snippet.setProblem(recipe);
//        snippet.setOwner(user);
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
    public ResponseEntity<?> register(User user) {
        EntityModel<User> entityModel = userAssembler.toModel(userRepository.save(user));
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @Override
    public EntityModel<Snippet> getSnippet(long index) {
        Snippet snippet = snippetRepository
                .findById(index)
                .orElseThrow(EntityNotFoundException::new);
        return assembler.toModel(snippet);
    }

    @Override
    public EntityModel<Recipe> getRecipe(long index) {
        Recipe recipe = recipeRepository
                .findById(index)
                .orElseThrow(EntityNotFoundException::new);
        return recipeAssembler.toModel(recipe);
    }

    @Override
    public EntityModel<User> findByEmail(String email) {
        return userAssembler.toModel(userRepository.findByEmail(email));
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
        return CollectionModel.of(latest, linkTo(methodOn(CodeController.class).getLatestCode()).withSelfRel());
    }

    @Override
    public CollectionModel<EntityModel<Snippet>> allByLang(String lang) {
        List<EntityModel<Snippet>> byLang = snippetRepository
                .findAll()
                .parallelStream()
                .filter(snippet -> snippet.getLang().equals(lang))
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(byLang, linkTo(methodOn(CodeController.class).getAllByLang(lang)).withSelfRel());
    }

    @Override
    public CollectionModel<EntityModel<Snippet>> allByRecipe(long recipeId) {
        List<EntityModel<Snippet>> byLang = snippetRepository
                .findAll()
                .parallelStream()
                .filter(snippet -> snippet.getProblem().getId() == recipeId)
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(byLang, linkTo(methodOn(CodeController.class).getAllByRecipe(recipeId)).withSelfRel());
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
        return CollectionModel.of(byLang, linkTo(methodOn(CodeController.class).getLatestByLang(lang)).withSelfRel());
    }

    @Override
    public ResponseEntity<?> drop() {
        snippetRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
