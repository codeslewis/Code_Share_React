package io.lewiscodes.codesharereact.services;

import io.lewiscodes.codesharereact.models.Snippet;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface CodeService {
    ResponseEntity<?> addSnippet(Snippet snippet);
    EntityModel<Snippet> getSnippet(long index);
    CollectionModel<EntityModel<Snippet>> getLatest();
    CollectionModel<EntityModel<Snippet>> allByLang(String lang);
    CollectionModel<EntityModel<Snippet>> latestByLang(String lang);
    ResponseEntity<?> drop();
}
