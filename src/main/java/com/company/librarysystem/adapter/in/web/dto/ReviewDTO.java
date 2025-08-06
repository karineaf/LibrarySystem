package com.company.librarysystem.adapter.in.web.dto;

import com.company.librarysystem.domain.model.Book;

import lombok.Data;

import java.time.LocalDate;


@Data
public class ReviewDTO {
    private Long id;
    private Long userId;
    private Book book;
    private int rating;
    private String comment;
    private LocalDate createdAt;
}
