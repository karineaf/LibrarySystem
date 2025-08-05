package com.company.librarysystem.adapter.in.web.dto.mapper;

import com.company.librarysystem.adapter.in.web.dto.AuthorDTO;
import com.company.librarysystem.domain.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AuthorDTOMapper {

    @Mapping(target = "books", expression = "java(author.getBooks().stream().map(book -> book.getId()).collect(Collectors.toList()))")
    AuthorDTO toDto(Author author);

    Author toModel(AuthorDTO dto);

}
