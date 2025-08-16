package com.company.librarysystem.domain.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
@Builder
public class Author {
    private final Long id;
    private final String name;
    @Builder.Default
    private List<Book> books = new ArrayList<>();

    public Author(Long id, @NonNull String name, List<Book> books) {

        this.id = id;
        this.name = name;
        this.books = (books != null) ? books : new ArrayList<>();

    }

    public void addBook(Book book) {
        if (book != null && !books.contains(book)) {
            books.add(book);
        }
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

}

