package com.company.librarysystem.adapter.in.web.controller;

import com.company.librarysystem.adapter.in.web.dto.BookDTO;
import com.company.librarysystem.adapter.in.web.dto.mapper.BookDTOMapper;
import com.company.librarysystem.application.service.BookService;
import com.company.librarysystem.domain.model.Book;
import com.company.librarysystem.domain.model.enums.Genre;
import com.company.librarysystem.domain.model.enums.TargetAudience;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/search/by_title/{title}")
    public ResponseEntity<List<BookDTO>> findByTitle(@PathVariable String title) {
        List<BookDTO> list = service.findByTitle(title)
                .stream()
                .map(mapper::toDTO)
                .collect(toList());
        return ok(list);
    }

    @GetMapping("/search/by_release_date/{releaseDate}")
    public ResponseEntity<List<BookDTO>> findByReleaseDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate releaseDate) {
        List<BookDTO> list = service.findByReleaseDate(releaseDate)
                .stream()
                .map(mapper::toDTO)
                .collect(toList());
        return ok(list);
    }

    @GetMapping("/search/by_genre/{genre}")
    public ResponseEntity<List<BookDTO>> findByGenre(@PathVariable String genre) {
        List<BookDTO> list = service.findByGenre(Genre.fromValue(genre))
                .stream()
                .map(mapper::toDTO)
                .collect(toList());
        return ok(list);
    }

    @GetMapping("/search/by_target_audience/{targetAudience}")
    public ResponseEntity<List<BookDTO>> findByTargetAudience(@PathVariable String targetAudience) {
        List<BookDTO> list = service.findByTargetAudience(TargetAudience.fromValue(targetAudience))
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