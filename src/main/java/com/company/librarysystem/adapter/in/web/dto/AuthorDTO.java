package com.company.librarysystem.adapter.in.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@JsonInclude(NON_NULL)
public class AuthorDTO {
    private Long id;
    private String name;
    private List<BookDTO> books;
}