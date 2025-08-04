package com.company.librarysystem.adapter.out.persistence.entity;

import com.company.librarysystem.domain.model.enums.Genre;
import com.company.librarysystem.domain.model.enums.TargetAudience;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "book")
@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
public class BookEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column
    private LocalDate releaseDate;

    @Column
    private Integer pagesNumber;

    @Enumerated(STRING)
    @Column(nullable = false)
    private Genre genre;

    @Enumerated(STRING)
    @Column(nullable = false)
    private TargetAudience targetAudience;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<AuthorEntity> authors = new ArrayList<>();


    public void addAuthor(AuthorEntity author) {
        if (author != null && !authors.contains(author)) {
            authors.add(author);
            author.getBooks().add(this);
        }
    }

    public void removeAuthor(AuthorEntity author) {
        if (author != null && authors.contains(author)) {
            authors.remove(author);
            author.getBooks().remove(this);
        }
    }
}