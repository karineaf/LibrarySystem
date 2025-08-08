package com.company.librarysystem.adapter.in.web.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class AuthorDTO {
    private Long id;
    private String name;
    private List<BookDTO> books;
}