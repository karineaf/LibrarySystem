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
    @Getter
    private List<Book> books = new ArrayList<>();

    public Author(Long id, @NonNull String name, @NonNull List<Book> books) {

        this.id = id;
        this.name = name;
        this.books.addAll(books);

        for (Book book : books) this.addBook(book);
    }

    public void addBook(Book book) {
        if (book != null & !books.contains(book)) {
            books.add(book);
            book.addAuthor(this);
        }
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.removeAuthor(this);
    }

}
