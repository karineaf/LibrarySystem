package com.company.librarysystem.domain.model;

import com.company.librarysystem.domain.model.enums.Genre;
import com.company.librarysystem.domain.model.enums.TargetAudience;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
@Builder
public class Book {
    private final Long id;
    private final String title;
    private List<Author> authors = new ArrayList<>();
    private final String description;
    private final Integer pagesNumber;
    private final LocalDate releaseDate;
    private final Genre genre;
    private final TargetAudience targetAudience;

    public Book(Long id, @NonNull String title, @NonNull List<Author> authors, String description,
                @NonNull Integer pagesNumber, LocalDate releaseDate, Genre genre, TargetAudience targetAudience) {

        this.id = id;
        this.title = title;
        this.description = (description == null || description.isBlank()) ? "N/A" : description;
        this.releaseDate = releaseDate;
        this.pagesNumber = pagesNumber;
        this.genre = (genre != null) ? genre : Genre.UNDEFINED;
        this.targetAudience = (targetAudience != null) ? targetAudience : TargetAudience.UNDEFINED;

        for (Author author : authors) this.addAuthor(author);

    }

    public void addAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
        if (!authors.contains(author)) {
            authors.add(author);
            author.addBook(this);
        }
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
        author.removeBook(this);
    }

}
