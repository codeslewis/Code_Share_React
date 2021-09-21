package io.lewiscodes.codesharereact.services;

import io.lewiscodes.codesharereact.models.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> register(User user);
    EntityModel<User> findByEmail(String email);
}
