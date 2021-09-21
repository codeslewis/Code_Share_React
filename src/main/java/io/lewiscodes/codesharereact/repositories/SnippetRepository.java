package io.lewiscodes.codesharereact.repositories;

import io.lewiscodes.codesharereact.models.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnippetRepository extends JpaRepository<Snippet, Long> {
}
