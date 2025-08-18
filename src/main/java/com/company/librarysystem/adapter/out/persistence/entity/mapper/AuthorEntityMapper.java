package com.company.librarysystem.adapter.out.persistence.entity.mapper;

import com.company.librarysystem.domain.model.Author;
import com.company.librarysystem.adapter.out.persistence.entity.AuthorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorEntityMapper {
    private final BookEntityMapper bookMapper;

    public Author toModel(AuthorEntity entity) {
        if (entity == null) return null;

        Author author = toModelWithoutBooks(entity);

        if (entity.getBooks() != null && !entity.getBooks().isEmpty())
            entity.getBooks()
                    .forEach(bookEntity -> author.addBook(bookMapper.toModelWithoutAuthors(bookEntity)));

        return author;
    }

    public Author toModelWithoutBooks(AuthorEntity entity) {
        if (entity == null) return null;

        return Author.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public AuthorEntity toEntity(Author model) {
        if (model == null) return null;

        AuthorEntity entity = toEntityWithoutBooks(model);

        if (model.getBooks() != null && !model.getBooks().isEmpty())
            model.getBooks()
                    .forEach(book -> entity.addBook(bookMapper.toEntityWithoutAuthors(book)));

        return entity;
    }

    public AuthorEntity toEntityWithoutBooks(Author model) {
        if (model == null) return null;

        return AuthorEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .books(new ArrayList<>())
                .build();
    }
}