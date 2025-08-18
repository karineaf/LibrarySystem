package com.company.librarysystem.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.*;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@Entity(name = "author")
@Table(name = "author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "authors", cascade = {MERGE})
    private List<BookEntity> books = new ArrayList<>();

    public void addBook(@NonNull BookEntity book) {
        if (!books.contains(book)) {
            books.add(book);
            book.getAuthors().add(this);
        }
    }

    public void removeBook(@NonNull BookEntity book) {
        if (books.contains(book)) {
            books.remove(book);
            book.getAuthors().remove(this);
        }
    }
}