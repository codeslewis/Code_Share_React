package io.lewiscodes.codesharereact.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "APPLICATION_USER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
public class User {
    @Id
    @Column(name = "id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = "email", columnDefinition = "VARCHAR", unique = true)
    private String email;
    @Column(name = "password", columnDefinition = "VARCHAR")
    @JsonIgnore
    private String password;
    private boolean isActive;
    private String roles;

    @OneToMany
    private List<Snippet> code;

    public User() {
        super();
        this.code = new ArrayList<>();
    }

    public User(String email, String password) {
        this();
        this.email = email;
        this.password = password;
    }

    public User(Long id, String email, String password, boolean isActive, String roles) {
        this();
        this.id = id;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.roles = roles;
    }

    public void addSnippet(Snippet snippet) {
        code.add(snippet);
    }
}
