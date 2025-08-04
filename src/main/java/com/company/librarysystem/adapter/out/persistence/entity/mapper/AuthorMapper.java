package com.company.librarysystem.adapter.out.persistence.entity.mapper;

import com.company.librarysystem.domain.model.Author;
import com.company.librarysystem.domain.model.Book;
import com.company.librarysystem.adapter.out.persistence.entity.AuthorEntity;
import lombok.NonNull;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class AuthorMapper {
    public static Author toModel(@NonNull AuthorEntity entity) {

        List<Book> books = (entity.getBooks() == null) ? emptyList()
                : entity.getBooks().stream()
                .map(BookMapper::toModel)
                .collect(toList());

        return Author.builder()
                .id(entity.getId())
                .name(entity.getName())
                .books(books)
                .build();
    }

    public static AuthorEntity toEntity(@NonNull Author model) {

        AuthorEntity entity = AuthorEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .build();

        entity.getBooks().clear();

        if (model.getBooks() != null) {

            model.getBooks().stream()
                    .map(BookMapper::toEntity)
                    .forEach(entity::addBook);
        }

        return entity;
    }
}
