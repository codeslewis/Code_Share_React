package io.lewiscodes.codesharereact.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "recipes")
@Getter
@Setter
@ToString
public class Recipe {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String type;

    @OneToMany
    @ToString.Exclude
    private List<Snippet> solutions;

    public Recipe() {
        super();
        this.solutions = new ArrayList<>();
    }

    public Recipe(String title, String description, String type) {
        this();
        this.title = title;
        this.description = description;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
