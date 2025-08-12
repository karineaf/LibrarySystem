package com.company.librarysystem.adapter.in.web.controller;

import com.company.librarysystem.adapter.in.web.dto.BookDTO;
import com.company.librarysystem.adapter.in.web.dto.mapper.BookDTOMapper;
import com.company.librarysystem.application.service.BookService;
import com.company.librarysystem.domain.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;
    private final BookDTOMapper mapper;

    @PostMapping
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO dto) {
        Book book = mapper.toModel(dto);
        Book saved = service.save(book);
        return ok(mapper.toDTO(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(mapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll() {
        List<BookDTO> list = service.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(toList());
        return ok(list);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<BookDTO>> findByTitle(@PathVariable String title) {
        List<BookDTO> list = service.findByTitle(title)
                .stream()
                .map(mapper::toDTO)
                .collect(toList());
        return ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}