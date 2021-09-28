package io.lewiscodes.codesharereact.data;

import io.lewiscodes.codesharereact.models.Recipe;
import io.lewiscodes.codesharereact.models.Snippet;
import io.lewiscodes.codesharereact.models.User;
import io.lewiscodes.codesharereact.repositories.RecipeRepository;
import io.lewiscodes.codesharereact.repositories.SnippetRepository;
import io.lewiscodes.codesharereact.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;
    private final SnippetRepository snippetRepository;

    @Autowired
    public DatabaseLoader(UserRepository userRepository, RecipeRepository recipeRepository, SnippetRepository snippetRepository) {
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
        this.snippetRepository = snippetRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User(1L, "bob@gmail.com", "supersecretpassword", true, "ROLE_USER");
        userRepository.save(user);
        Recipe recipe = new Recipe("Hello, world", "A first program to get started coding in a new language", "Basic");
        recipeRepository.save(recipe);
        Snippet snippet = new Snippet("fun main() {\n  print(\"Hello, world!\")\n}");
        snippetRepository.save(snippet);
        snippet.setLang("Kotlin");
        snippet.setOwner(user);
        snippet.setProblem(recipe);
        user.addSnippet(snippet);
        recipe.addSnippet(snippet);

        userRepository.save(user);
        recipeRepository.save(recipe);
        snippetRepository.save(snippet);
    }
}
