package com.company.librarysystem.adapter.out.persistence;

import com.company.librarysystem.adapter.out.persistence.entity.BookEntity;
import com.company.librarysystem.adapter.out.persistence.entity.mapper.BookMapper;
import com.company.librarysystem.adapter.out.persistence.repository.BookRepositoryJpa;
import com.company.librarysystem.domain.model.Book;
import com.company.librarysystem.domain.model.Reservation;
import com.company.librarysystem.domain.model.enums.Genre;
import com.company.librarysystem.domain.model.enums.TargetAudience;
import com.company.librarysystem.domain.port.out.BookRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.company.librarysystem.adapter.out.persistence.entity.mapper.BookMapper.toEntity;
import static com.company.librarysystem.adapter.out.persistence.entity.mapper.BookMapper.toModel;

@RequiredArgsConstructor
public class BookRepositoryAdapter implements BookRepository {

    private final BookRepositoryJpa repository;

    @Override
    public Book save(Book book) {
        BookEntity entity = toEntity(book);
        return BookMapper.toModel(repository.save(entity));
    }

    @Override
    public Optional<Book> findById(Long id) {
        return repository.findById(id).map(BookMapper::toModel);
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        for (BookEntity entity : repository.findAll())
            books.add(toModel(entity));
        return books;
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return repository.findByTitle(title).map(BookMapper::toModel);
    }

    @Override
    public List<Book> findByReleaseDate(LocalDate releaseDate) {
        return repository.findByReleaseDate(releaseDate).stream()
                .map(BookMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByGenre(Genre genre) {
        return repository.findByGenre(genre).stream()
                .map(BookMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByTargetAudience(TargetAudience targetAudience) {
        return repository.findByTargetAudience(targetAudience).stream()
                .map(BookMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByAuthorId(Long authorId) {
        return repository.findByAuthors_Id(authorId).stream()
                .map(BookMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

