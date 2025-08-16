package com.company.librarysystem.adapter.in.web.dto.mapper;

import com.company.librarysystem.adapter.in.web.dto.BookDTO;
import com.company.librarysystem.domain.model.Book;
import com.company.librarysystem.domain.model.enums.Genre;
import com.company.librarysystem.domain.model.enums.TargetAudience;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BookDTOMapper {
    private final AuthorDTOMapper authorDTOMapper;

    public BookDTOMapper(@Lazy AuthorDTOMapper authorDTOMapper) {
        this.authorDTOMapper = authorDTOMapper;
    }

    public BookDTO toDTO(Book book) {
        if (book == null) return null;

        BookDTO bookDTO = toDTOWithoutAuthors(book);

        if (book.getAuthors() != null && !book.getAuthors().isEmpty())
            bookDTO.setAuthors(book.getAuthors().stream().map(authorDTOMapper::toDTOWithoutBooks).collect(Collectors.toList())

        );

        return bookDTO;

    }

    public BookDTO toDTOWithoutAuthors(Book book) {
        if (book == null) return null;

        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .description(book.getDescription())
                .pagesNumber(book.getPagesNumber())
                .releaseDate(book.getReleaseDate())
                .genre(book.getGenre().name())
                .targetAudience(book.getTargetAudience().name())
                .build();
    }

    public Book toModel(BookDTO dto) {
        if (dto == null) return null;

        Book book = toModelWithoutAuthors(dto);

        if (dto.getAuthors() != null && !dto.getAuthors().isEmpty())
            dto.getAuthors().forEach(authorDTO -> book.addAuthor(authorDTOMapper.toModelWithoutBooks(authorDTO)));

        return book;
    }

    public Book toModelWithoutAuthors(BookDTO dto) {
        if (dto == null) return null;

        return Book.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .releaseDate(dto.getReleaseDate())
                .genre(Genre.valueOf(dto.getGenre()))
                .targetAudience(TargetAudience.valueOf(dto.getTargetAudience()))
                .build();
    }
}
