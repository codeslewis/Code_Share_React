package io.lewiscodes.codesharereact.repositories;

import io.lewiscodes.codesharereact.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
