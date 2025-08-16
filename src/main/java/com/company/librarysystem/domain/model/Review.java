package com.company.librarysystem.domain.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@EqualsAndHashCode
@Builder
public class Review {

    private final Long id;
    private final Long userId;
    @Setter
    private Book book;
    private final Integer rating;
    private final String comment;
    private final LocalDate createdAt;

    public Review(Long id, @NonNull Long userId, Book book, @NonNull Integer rating, String comment,
                  LocalDate createdAt) {

        if (rating < 1 || rating > 5)
            throw new IllegalArgumentException("Rating must be between 1 and 5");

        this.id = id;
        this.userId = userId;
        this.book = book;
        this.rating = rating;
        this.comment = (comment == null || comment.isBlank()) ? "N/A" : comment;
        this.createdAt = createdAt;
    }

}
