package com.company.librarysystem.adapter.in.web.dto.mapper;

import com.company.librarysystem.adapter.in.web.dto.BookDTO;
import com.company.librarysystem.domain.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookDTOMapper {
    @Mapping(target = "authorNames", expression = "java(book.getAuthors().stream().map(author -> author.getName()).collect(Collectors.toList()))")
    @Mapping(target = "genre", expression = "java(book.getGenre().name())")
    @Mapping(target = "targetAudience", expression = "java(book.getTargetAudience().name())")
    BookDTO toDto(Book book);

    @Mapping(target = "genre", expression = "java(domain.model.enums.Genre.valueOf(dto.getGenre()))")
    @Mapping(target = "targetAudience", expression = "java(domain.model.enums.TargetAudience.valueOf(dto.getTargetAudience()))")
    Book toModel(BookDTO dto);
}
