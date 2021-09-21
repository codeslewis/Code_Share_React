package io.lewiscodes.codesharereact.services;

import io.lewiscodes.codesharereact.models.Recipe;
import io.lewiscodes.codesharereact.models.Snippet;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface CodeService {
    ResponseEntity<?> addSnippet(Snippet snippet);
    ResponseEntity<?> addRecipe(Recipe recipe);
    EntityModel<Snippet> getSnippet(long index);
    EntityModel<Recipe> getRecipe(long index);
    CollectionModel<EntityModel<Snippet>> getLatest();
    CollectionModel<EntityModel<Recipe>> getAllRecipes();
    CollectionModel<EntityModel<Snippet>> allByLang(String lang);
    CollectionModel<EntityModel<Snippet>> latestByLang(String lang);
    ResponseEntity<?> drop();
}
