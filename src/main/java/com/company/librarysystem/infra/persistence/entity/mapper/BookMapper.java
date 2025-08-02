package com.company.librarysystem.infra.persistence.entity.mapper;

import com.company.librarysystem.domain.model.Book;
import com.company.librarysystem.domain.model.Author;
import com.company.librarysystem.domain.model.enums.Genre;
import com.company.librarysystem.domain.model.enums.TargetAudience;
import com.company.librarysystem.infra.persistence.entity.BookEntity;
import com.company.librarysystem.infra.persistence.entity.AuthorEntity;
import lombok.NonNull;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {

    public static Book toModel(BookEntity entity) {
        if (entity == null) return null;

        List<Author> authors = (entity.getAuthors() == null)
                ? Collections.emptyList()
                : entity.getAuthors().stream()
                .map(AuthorMapper::toModel)
                .collect(Collectors.toList());

        return Book.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .authors(authors)
                .description(entity.getDescription())
                .pagesNumber(entity.getPagesNumber())
                .releaseDate(entity.getReleaseDate())
                .genre(entity.getGenre() != null ? entity.getGenre() : Genre.UNDEFINED)
                .targetAudience(entity.getTargetAudience() != null ? entity.getTargetAudience() : TargetAudience.UNDEFINED)
                .build();
    }

    public static BookEntity toEntity(@NonNull Book model) {

        return BookEntity.builder()
                .id(model.getId())
                .title(model.getTitle())
                .description(model.getDescription())
                .pagesNumber(model.getPagesNumber())
                .releaseDate(model.getReleaseDate())
                .genre(model.getGenre())
                .targetAudience(model.getTargetAudience())
                .build()
                // Depois adiciona autores para manter a relação bidirecional
                ;
    }
}
