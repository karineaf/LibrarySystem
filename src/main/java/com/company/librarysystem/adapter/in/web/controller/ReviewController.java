package com.company.librarysystem.adapter.in.web.controller;

import com.company.librarysystem.adapter.in.web.dto.ReviewDTO;
import com.company.librarysystem.adapter.in.web.dto.mapper.ReviewDTOMapper;
import com.company.librarysystem.application.service.ReviewService;
import com.company.librarysystem.domain.model.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.*;


@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService service;
    private final ReviewDTOMapper dtoMapper;

    @PostMapping
    public ResponseEntity<ReviewDTO> create(@RequestBody ReviewDTO dto) {
        Review review = dtoMapper.toModel(dto);
        Review saved = service.saveReview(review);
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
}

