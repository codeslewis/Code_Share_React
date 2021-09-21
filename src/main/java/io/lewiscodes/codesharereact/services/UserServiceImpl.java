package io.lewiscodes.codesharereact.services;

import io.lewiscodes.codesharereact.models.User;
import io.lewiscodes.codesharereact.models.UserModelAssembler;
import io.lewiscodes.codesharereact.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repo;
    private final UserModelAssembler assembler;

    public UserServiceImpl(
            @Autowired UserRepository repo,
            @Autowired UserModelAssembler assembler
    ) {
        this.repo = repo;
        this.assembler = assembler;
    }

    @Override
    public ResponseEntity<?> register(User user) {
        EntityModel<User> entityModel = assembler.toModel(repo.save(user));
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @Override
    public EntityModel<User> findByEmail(String email) {
        return assembler.toModel(repo.findByEmail(email));
    }
}
