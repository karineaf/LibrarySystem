package com.company.librarysystem.adapter.in.web.dto.mapper;

import com.company.librarysystem.adapter.in.web.dto.AuthorDTO;
import com.company.librarysystem.domain.model.Author;

import java.util.stream.Collectors;


public class AuthorDTOMapper {

    public static AuthorDTO toDTO(Author author) {
        if (author == null)
            return null;

        return AuthorDTO.builder()
                .id(author.getId())
                .name(author.getName())
                .books(
                        author.getBooks() != null
                                ? author.getBooks().stream()
                                .map(BookDTOMapper::toDTO)
                                .collect(Collectors.toList())
                                : null
                )
                .build();
    }


    public static Author toModel(AuthorDTO dto) {
        if (dto == null)
            return null;

        return Author.builder()
                .id(dto.getId())
                .name(dto.getName())
                .books(
                        dto.getBooks() != null
                                ? dto.getBooks().stream()
                                .map(BookDTOMapper::toModel)
                                .collect(Collectors.toList())
                                : null
                )
                .build();
    }
}
