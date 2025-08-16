package com.company.librarysystem.adapter.in.web.controller;

import com.company.librarysystem.adapter.in.web.dto.AuthorDTO;
import com.company.librarysystem.adapter.in.web.dto.mapper.AuthorDTOMapper;
import com.company.librarysystem.application.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService service;
    private final AuthorDTOMapper mapper;

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        List<AuthorDTO> dtoList = service.findAll().stream()
                .map(mapper::toDTO)
                .collect(toList());
        return ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long id) {
        return service.findById(id)
                .map(author -> ok(mapper.toDTO(author)))
                .orElse(notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<AuthorDTO>> getAuthorsByName(@RequestParam String name) {
        List<AuthorDTO> authors = service.findByName(name)
                .stream().map(mapper::toDTO).collect(toList());

        if (authors.isEmpty())
            return noContent().build();

        return ok(authors);
    }

    @GetMapping("/search/by_book/{book_id}")
    public ResponseEntity<List<AuthorDTO>> findByBookId(@PathVariable("book_id") Long bookId) {
        List<AuthorDTO> authors = service.findByBookId(bookId)
                .stream()
                .map(mapper::toDTO)
                .toList();

        return ResponseEntity.ok(authors);
    }

    @GetMapping("/search/by_book_title")
    public ResponseEntity<List<AuthorDTO>> findByBookTitle(@RequestParam("book_title") String bookTitle) {
        List<AuthorDTO> authors = service.findByBookTitle(bookTitle)
                .stream()
                .map(mapper::toDTO)
                .toList();

        return ResponseEntity.ok(authors);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO dto) {
        return new ResponseEntity<>(
                mapper.toDTO(
                        service.create(
                                mapper.toModel(dto))), CREATED);
    }

    // #TODO - FIX BUG - DELETING OTHER AUTHORS IN THE SAME BOOK
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
    //     service.delete(id);
    //     return noContent().build();
    // }
}