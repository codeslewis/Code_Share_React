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
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="APP_USER_SEQ")
    @SequenceGenerator(name="APP_USER_SEQ" ,sequenceName="APP_USER_SEQ" ,allocationSize=1)
    private Long id;
    @Column(name = "email", columnDefinition = "VARCHAR", unique = true)
    private String email;
    @Column(name = "password", columnDefinition = "VARCHAR")
    @JsonIgnore
    private String password;

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

    public void addSnippet(Snippet snippet) {
        code.add(snippet);
    }
}
