package io.lewiscodes.codesharereact.models;

import io.lewiscodes.codesharereact.controllers.ApiController;
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
                linkTo(methodOn(ApiController.class).getLatestCode()).withRel("Latest Code snippets")
        );
    }

    @Override
    public CollectionModel<EntityModel<Recipe>> toCollectionModel(Iterable<? extends Recipe> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
