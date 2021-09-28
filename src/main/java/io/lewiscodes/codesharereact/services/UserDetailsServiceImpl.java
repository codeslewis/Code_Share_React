package io.lewiscodes.codesharereact.services;

import io.lewiscodes.codesharereact.models.User;
import io.lewiscodes.codesharereact.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository repository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("The user: " + userName + " was not found."));
        return user.map(UserDetailsImpl::new).get();
    }
}
