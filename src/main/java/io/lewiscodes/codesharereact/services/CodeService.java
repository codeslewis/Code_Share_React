package io.lewiscodes.codesharereact.services;

import io.lewiscodes.codesharereact.models.Recipe;
import io.lewiscodes.codesharereact.models.Snippet;
import io.lewiscodes.codesharereact.models.User;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface CodeService {
    ResponseEntity<?> addSnippet(Snippet snippet, long recipeId, long userId);
    ResponseEntity<?> addRecipe(Recipe recipe);
    ResponseEntity<?> register(User user);

    EntityModel<Snippet> getSnippet(long index);
    EntityModel<Recipe> getRecipe(long index);
    EntityModel<User> findByEmail(String email);

    CollectionModel<EntityModel<Snippet>> getLatest();
    CollectionModel<EntityModel<Recipe>> getAllRecipes();

    CollectionModel<EntityModel<Snippet>> allByLang(String lang);
    CollectionModel<EntityModel<Snippet>> allByRecipe(long recipeId);
    CollectionModel<EntityModel<Snippet>> latestByLang(String lang);

    ResponseEntity<?> drop();
}
