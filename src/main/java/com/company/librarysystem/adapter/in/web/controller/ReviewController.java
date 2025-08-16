package com.company.librarysystem.adapter.in.web.controller;

import com.company.librarysystem.adapter.in.web.dto.ReviewCreateDTO;
import com.company.librarysystem.adapter.in.web.dto.ReviewDTO;
import com.company.librarysystem.adapter.in.web.dto.mapper.ReviewDTOMapper;
import com.company.librarysystem.application.service.ReviewService;
import com.company.librarysystem.domain.model.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;
import static org.springframework.http.ResponseEntity.*;


@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService service;
    private final ReviewDTOMapper dtoMapper;

    @PostMapping
    public ResponseEntity<ReviewDTO> create(@RequestBody ReviewCreateDTO dto) {
        Review saved = service.createReview(dto.getUserId(), dto.getBookId(), dto.getRating(), dto.getComment());
        return ok(dtoMapper.toDTO(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> findById(@PathVariable Long id) {
        return service.getReviewById(id)
                .map(dtoMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> findAll() {
        List<ReviewDTO> list = service.getAllReviews()
                .stream()
                .map(dtoMapper::toDTO)
                .collect(toList());
        return ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteReview(id);
        return noContent().build();
    }

    @GetMapping("/search/by_user/{userId}")
    public ResponseEntity<List<ReviewDTO>> findByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(
                service.getReviewByUserId(userId)
                        .stream()
                        .map(dtoMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/search/by_book/{bookId}")
    public ResponseEntity<List<ReviewDTO>> findByBookId(@PathVariable Long bookId) {
        return ResponseEntity.ok(
                service.getReviewByBookId(bookId)
                        .stream()
                        .map(dtoMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/search/by_book_title")
    public ResponseEntity<List<ReviewDTO>> findByBookTitle(@RequestParam("book_title") String bookTitle) {
        return ResponseEntity.ok(
                service.getReviewByBookTitle(bookTitle)
                        .stream()
                        .map(dtoMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/search/by_rating/{rating}")
    public ResponseEntity<List<ReviewDTO>> findByRating(@PathVariable Integer rating) {
        return ResponseEntity.ok(
                service.getReviewsByRating(rating)
                        .stream()
                        .map(dtoMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/search/by_created_at/{createdAt}")
    public ResponseEntity<List<ReviewDTO>> findByCreatedAt(
            @PathVariable @DateTimeFormat(iso = DATE) LocalDate createdAt) {
        return ResponseEntity.ok(
                service.getReviewsByCreatedAt(createdAt)
                        .stream()
                        .map(dtoMapper::toDTO)
                        .toList()
        );
    }

}

