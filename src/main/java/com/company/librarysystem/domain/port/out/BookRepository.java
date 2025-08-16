package com.company.librarysystem.domain.port.out;

import com.company.librarysystem.domain.model.Book;
import com.company.librarysystem.domain.model.enums.Genre;
import com.company.librarysystem.domain.model.enums.TargetAudience;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);
    Optional<Book> findById(Long id);
    List<Book> findAll();
    void deleteById(Long id);

    Optional<Book> findByTitle(String title);
    List<Book> findByReleaseDate(LocalDate releaseDate);
    List<Book> findByGenre(Genre genre);
    List<Book> findByTargetAudience(TargetAudience targetAudience);
    List<Book> findByAuthor_Id(Long authorId);
}


