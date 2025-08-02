package com.company.librarysystem.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.*;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "author", cascade = {PERSIST, MERGE})
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