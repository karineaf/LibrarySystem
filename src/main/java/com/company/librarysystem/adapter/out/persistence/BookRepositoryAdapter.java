package com.company.librarysystem.adapter.out.persistence;

import com.company.librarysystem.adapter.out.persistence.entity.BookEntity;
import com.company.librarysystem.adapter.out.persistence.entity.mapper.BookEntityMapper;
import com.company.librarysystem.adapter.out.persistence.repository.BookRepositoryJpa;
import com.company.librarysystem.domain.model.Book;
import com.company.librarysystem.domain.model.enums.Genre;
import com.company.librarysystem.domain.model.enums.TargetAudience;
import com.company.librarysystem.domain.port.out.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@RequiredArgsConstructor
@Repository
public class BookRepositoryAdapter implements BookRepository {

    private final BookRepositoryJpa repository;
    private final BookEntityMapper mapper;

    @Override
    public Book save(Book book) {
        BookEntity entity = mapper.toEntity(book);
        return mapper.toModel(repository.save(entity));
    }

    @Override
    public Optional<Book> findById(Long id) {
        return repository.findById(id).map(mapper::toModel);
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        for (BookEntity entity : repository.findAll())
            books.add(mapper.toModel(entity));
        return books;
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return repository.findByTitle(title).map(mapper::toModel);
    }

    @Override
    public List<Book> findByReleaseDate(LocalDate releaseDate) {
        return repository.findByReleaseDate(releaseDate).stream()
                .map(mapper::toModel)
                .collect(toList());
    }

    @Override
    public List<Book> findByGenre(Genre genre) {
        return repository.findByGenre(genre).stream()
                .map(mapper::toModel)
                .collect(toList());
    }

    @Override
    public List<Book> findByTargetAudience(TargetAudience targetAudience) {
        return repository.findByTargetAudience(targetAudience).stream()
                .map(mapper::toModel)
                .collect(toList());
    }

    @Override
    public List<Book> findByAuthor_Id(Long authorId) {
        return repository.findByAuthors_Id(authorId).stream()
                .map(mapper::toModel)
                .collect(toList());
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


    @Override
    public void delete(Book book) {
        BookEntity bookEntity = mapper.toEntity(book);
        repository.delete(bookEntity);
    }
}

