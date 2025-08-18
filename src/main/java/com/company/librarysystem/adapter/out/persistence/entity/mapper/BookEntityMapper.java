package com.company.librarysystem.adapter.out.persistence.entity.mapper;

import com.company.librarysystem.domain.model.Book;
import com.company.librarysystem.adapter.out.persistence.entity.BookEntity;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BookEntityMapper {

    private final AuthorEntityMapper authorMapper;

    public BookEntityMapper(@Lazy AuthorEntityMapper authorMapper) {
        this.authorMapper = authorMapper;
    }

    public Book toModel(BookEntity entity) {
        if (entity == null) return null;

        Book book = toModelWithoutAuthors(entity);

        if (entity.getAuthors() != null && !entity.getAuthors().isEmpty())
            entity.getAuthors()
                    .forEach(authorEntity -> book.addAuthor(authorMapper.toModelWithoutBooks(authorEntity)));

        return book;
    }

    public Book toModelWithoutAuthors(BookEntity entity) {
        if (entity == null) return null;

        return Book.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .pagesNumber(entity.getPagesNumber())
                .description(entity.getDescription())
                .releaseDate(entity.getReleaseDate())
                .genre(entity.getGenre())
                .targetAudience(entity.getTargetAudience())
                .authors(new ArrayList<>())
                .build();
    }
    public BookEntity toEntity(Book model) {
        if (model == null) return null;

        BookEntity entity = toEntityWithoutAuthors(model);

        if (model.getAuthors() != null && !model.getAuthors().isEmpty())
            model.getAuthors()
                    .forEach(author -> entity.addAuthor(authorMapper.toEntityWithoutBooks(author)));

        return entity;
    }

    public BookEntity toEntityWithoutAuthors(Book model) {
        if (model == null) return null;

        return BookEntity.builder()
                .id(model.getId())
                .title(model.getTitle())
                .description(model.getDescription())
                .pagesNumber(model.getPagesNumber())
                .releaseDate(model.getReleaseDate())
                .genre(model.getGenre())
                .targetAudience(model.getTargetAudience())
                .authors(new ArrayList<>())
                .build();
    }
}
