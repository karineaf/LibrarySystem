package com.company.librarysystem.application.service;

import com.company.librarysystem.domain.model.Book;
import com.company.librarysystem.domain.model.enums.Genre;
import com.company.librarysystem.domain.model.enums.TargetAudience;
import com.company.librarysystem.domain.port.out.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findByTitle(String title) {
        if  (title.isBlank())
            throw new IllegalArgumentException("Title cannot be null or blank");

        return bookRepository.findByTitle(title);
    }

    public List<Book> findByReleaseDate(LocalDate releaseDate) {
        return bookRepository.findByReleaseDate(releaseDate);
    }

    public List<Book> findByGenre(Genre genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> findByTargetAudience(TargetAudience targetAudience) {
        return bookRepository.findByTargetAudience(targetAudience);
    }

    public List<Book> findByAuthors(Long authorId) {
        return bookRepository.findByAuthor_Id(authorId);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}