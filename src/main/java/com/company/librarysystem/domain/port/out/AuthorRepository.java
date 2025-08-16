package com.company.librarysystem.domain.port.out;

import com.company.librarysystem.domain.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    Author save(Author author);
    Optional<Author> findById(Long id);
    List<Author> findAll();
    void deleteById(Long id);

    List<Author> findByName(String name);
    List<Author> findByBookId(Long bookId);
    List<Author> findByBookTitle(String bookTitle);
}
