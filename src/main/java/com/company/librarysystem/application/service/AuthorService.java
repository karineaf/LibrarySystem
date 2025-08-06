package com.company.librarysystem.application.service;

import com.company.librarysystem.domain.model.Author;
import com.company.librarysystem.domain.port.out.AuthorRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Author create(Author author) {
        return authorRepository.save(author);
    }

    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    public Optional<Author> findByName(String name) {
        return authorRepository.findByName(name);
    }

    public List<Author> findByBookId(Long id) {
        return authorRepository.findByBookId(id);
    }

    public List<Author> findByBookTitle(String bookTitle) {
        return authorRepository.findByBookTitle(bookTitle);
    }
}