package com.company.librarysystem.adapter.out.persistence;

import com.company.librarysystem.adapter.out.persistence.entity.AuthorEntity;
import com.company.librarysystem.adapter.out.persistence.entity.BookEntity;
import com.company.librarysystem.adapter.out.persistence.entity.mapper.AuthorMapper;
import com.company.librarysystem.adapter.out.persistence.entity.mapper.BookMapper;
import com.company.librarysystem.adapter.out.persistence.repository.AuthorRepositoryJpa;
import com.company.librarysystem.domain.model.Author;
import com.company.librarysystem.domain.model.Book;
import com.company.librarysystem.domain.port.out.AuthorRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import static com.company.librarysystem.adapter.out.persistence.entity.mapper.AuthorMapper.toEntity;
import static com.company.librarysystem.adapter.out.persistence.entity.mapper.AuthorMapper.toModel;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
public class AuthorRepositoryAdapter implements AuthorRepository {

    private final AuthorRepositoryJpa repository;

    @Override
    public Author save(Author author) {
        AuthorEntity entity = toEntity(author);
        return toModel(repository.save(entity));
    }

    @Override
    public Optional<Author> findById(Long id) {
        return repository.findById(id).map(AuthorMapper::toModel);
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        for (AuthorEntity entity : repository.findAll())
            authors.add(toModel(entity));
        return authors;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Author> findByName(String name) {
        return repository.findByName(name).map(AuthorMapper::toModel);
    }

    @Override
    public List<Author> findByBookId(Long bookId) {
        return repository.findByBooks_Id(bookId).stream()
                .map(AuthorMapper::toModel)
                .collect(toList());
    }

    @Override
    public List<Author> findByBookTitle(String bookTitle) {
        return repository.findByBooks_Title(bookTitle).stream()
                .map(AuthorMapper::toModel)
                .collect(toList());
    }

}

