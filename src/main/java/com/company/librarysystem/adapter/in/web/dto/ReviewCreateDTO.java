package com.company.librarysystem.adapter.in.web.dto;

import com.company.librarysystem.domain.model.Book;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@Builder
public class ReviewCreateDTO {
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("book_id")
    private Long bookId;
    private Integer rating;
    private String comment;
}
