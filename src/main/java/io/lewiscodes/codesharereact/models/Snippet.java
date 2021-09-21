package io.lewiscodes.codesharereact.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity(name = "snippets")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
public class Snippet implements Comparable<Snippet> {
    @Id
    @Column(name = "id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="SNIPPET_SEQ")
    @SequenceGenerator(name="SNIPPET_SEQ" ,sequenceName="SNIPPET_SEQ" ,allocationSize=1)
    private Long id;
    @Column(name = "code", columnDefinition = "VARCHAR")
    private String code;
    @Column(name = "date_added", columnDefinition = "TIMESTAMP")
    private final LocalDateTime dateAdded;
    @Column(name = "programming_language", columnDefinition = "VARCHAR")
    private String lang;

    @ManyToOne(fetch = FetchType.EAGER)
    private Recipe problem;

    @ManyToOne(fetch = FetchType.EAGER)
    private User owner;

    public Snippet(String code) {
        this.code = code;
        this.dateAdded = LocalDateTime.now();
    }

    public Snippet() {
        this.dateAdded = LocalDateTime.now();
    }

    public String getCode() {
        return code;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateAdded.format(formatter);
    }

    @Override
    // sorts by insertion order, latest snippet first
    public int compareTo(Snippet o) {
        return (int) (o.getId() - id);
    }
}

