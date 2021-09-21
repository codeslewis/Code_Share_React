package io.lewiscodes.codesharereact.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "APPLICATION_USER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
