package com.company.librarysystem.adapter.in.web.dto.mapper;

import com.company.librarysystem.adapter.in.web.dto.AuthorDTO;
import com.company.librarysystem.domain.model.Author;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AuthorDTOMapper {
    private final BookDTOMapper bookDTOMapper;

    public AuthorDTOMapper(BookDTOMapper bookDTOMapper) {
        this.bookDTOMapper = bookDTOMapper;
    }

    public AuthorDTO toDTO(Author author) {
        if (author == null) return null;

        AuthorDTO authorDTO = toDTOWithoutBooks(author);

        if (author.getBooks() != null && !author.getBooks().isEmpty())
            authorDTO.setBooks(
                    author.getBooks()
                            .stream()
                            .map(bookDTOMapper::toDTOWithoutAuthors)
                            .collect(Collectors.toList())
            );

        return authorDTO;
    }

    public AuthorDTO toDTOWithoutBooks(Author author) {
        if (author == null) return null;

        return AuthorDTO.builder()
                .id(author.getId())
                .name(author.getName())
                .build();
    }

    public Author toModel(AuthorDTO dto) {
        if (dto == null) return null;

        Author author = toModelWithoutBooks(dto);

        if (dto.getBooks() != null && !dto.getBooks().isEmpty())
            dto.getBooks() .forEach(bookDTO -> author.addBook(bookDTOMapper.toModelWithoutAuthors(bookDTO)));

        return author;
    }

    public Author toModelWithoutBooks(AuthorDTO dto) {
        if (dto == null) return null;

        return Author.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
