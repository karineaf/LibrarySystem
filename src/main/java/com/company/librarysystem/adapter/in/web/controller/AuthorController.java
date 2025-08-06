package com.company.librarysystem.adapter.in.web.controller;

import com.company.librarysystem.adapter.in.web.dto.AuthorDTO;
import com.company.librarysystem.adapter.in.web.dto.mapper.AuthorDTOMapper;
import com.company.librarysystem.application.service.AuthorService;
import com.company.librarysystem.domain.model.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService service;

    private final AuthorDTOMapper dtoMapper;

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        List<Author> authors = service.findAll();
        List<AuthorDTO> dtoList = authors.stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
        return ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long id) {
        return service.findById(id)
                .map(author -> ok(dtoMapper.toDto(author)))
                .orElse(notFound().build());
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO dto) {
        Author authorToSave = dtoMapper.toModel(dto);
        Author savedAuthor = service.create(authorToSave);
        return new ResponseEntity<>(dtoMapper.toDto(savedAuthor), CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}