package io.lewiscodes.codesharereact.models;

import io.lewiscodes.codesharereact.controllers.CodeController;
import io.lewiscodes.codesharereact.controllers.RecipeController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class RecipeModelAssembler implements RepresentationModelAssembler<Recipe, EntityModel<Recipe>> {
    @Override
    public EntityModel<Recipe> toModel(Recipe entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(RecipeController.class).getRecipe(entity.getId())).withSelfRel(),
                linkTo(methodOn(CodeController.class).getAllByRecipe(entity.getId())).withRel("Code for this recipe")
        );
    }

    @Override
    public CollectionModel<EntityModel<Recipe>> toCollectionModel(Iterable<? extends Recipe> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
