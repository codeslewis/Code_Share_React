package io.lewiscodes.codesharereact.controllers;

import io.lewiscodes.codesharereact.models.User;
import io.lewiscodes.codesharereact.services.CodeService;
import io.lewiscodes.codesharereact.services.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final CodeService service;

    public UserController(@Autowired SnippetService service) {
        this.service = service;
    }

    @PostMapping("api/user/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        return service.register(user);
    }

    @GetMapping("api/user/{email}")
    public EntityModel<User> getUser(@PathVariable String email) {
        return service.findByEmail(email);
    }
}
