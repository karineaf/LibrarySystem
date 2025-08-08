package com.company.librarysystem.adapter.in.web.dto.mapper;

import com.company.librarysystem.adapter.in.web.dto.BookDTO;
import com.company.librarysystem.domain.model.Book;
import com.company.librarysystem.domain.model.enums.Genre;
import com.company.librarysystem.domain.model.enums.TargetAudience;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BookDTOMapper {
    public static BookDTO toDTO(Book book) {
        if (book == null) return null;

        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .description(book.getDescription())
                .releaseDate(book.getReleaseDate())
                .genre(book.getGenre().name())
                .targetAudience(book.getTargetAudience().name())
                .authors(
                        book.getAuthors() != null
                                ? book.getAuthors().stream()
                                .map(AuthorDTOMapper::toDTO)
                                .collect(Collectors.toList())
                                : null
                )
                .build();

    }

    public static Book toModel(BookDTO dto) {
        if (dto == null) return null;

        return Book.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .releaseDate(dto.getReleaseDate())
                .genre(Genre.valueOf(dto.getGenre()))
                .targetAudience(TargetAudience.valueOf(dto.getTargetAudience()))
                .authors(
                        dto.getAuthors() != null
                                ? dto.getAuthors().stream()
                                .map(AuthorDTOMapper::toModel)
                                .collect(Collectors.toList())
                                : null
                )
                .build();
    }

}
