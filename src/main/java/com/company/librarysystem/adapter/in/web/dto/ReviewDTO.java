package com.company.librarysystem.adapter.in.web.dto;

import com.company.librarysystem.adapter.out.persistence.entity.BookEntity;
import com.company.librarysystem.domain.model.Book;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.LAZY;

@Data
public class ReviewDTO {
    private Long id;
    private Long userId;
    private Book book;
    private int rating;
    private String comment;
    private LocalDate createdAt;
}
