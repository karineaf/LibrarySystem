package com.company.librarysystem.adapter.in.web.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class BookDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDate releaseDate;
    private String genre;
    private String targetAudience;
    private List<AuthorDTO> authors;
}
