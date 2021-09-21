package io.lewiscodes.codesharereact.models;

import io.lewiscodes.codesharereact.controllers.ApiController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class SnippetModelAssembler implements RepresentationModelAssembler<Snippet, EntityModel<Snippet>> {
    @Override
    public EntityModel<Snippet> toModel(Snippet entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(ApiController.class).getCode(entity.getId())).withSelfRel(),
                linkTo(methodOn(ApiController.class).getAllByLang(entity.getLang())).withRel("All Code in this Language"),
                linkTo(methodOn(ApiController.class).getLatestCode()).withRel("Latest Code snippets")
        );
    }

    @Override
    public CollectionModel<EntityModel<Snippet>> toCollectionModel(Iterable<? extends Snippet> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
