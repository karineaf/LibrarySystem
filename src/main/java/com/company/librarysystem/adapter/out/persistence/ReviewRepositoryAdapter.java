package com.company.librarysystem.adapter.out.persistence;

import com.company.librarysystem.adapter.out.persistence.entity.ReviewEntity;
import com.company.librarysystem.adapter.out.persistence.entity.mapper.ReviewMapper;
import com.company.librarysystem.adapter.out.persistence.repository.ReviewRepositoryJpa;
import com.company.librarysystem.domain.model.Review;
import com.company.librarysystem.domain.port.out.ReviewRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.company.librarysystem.adapter.out.persistence.entity.mapper.ReviewMapper.toModel;

@RequiredArgsConstructor
public class ReviewRepositoryAdapter implements ReviewRepository {

    private final ReviewRepositoryJpa repository;

    @Override
    public Review save(Review review) {
        ReviewEntity entity = ReviewMapper.toEntity(review);
        entity = repository.save(entity);
        return toModel(entity);
    }

    @Override
    public Optional<Review> findById(Long id) {
        return repository.findById(id).map(ReviewMapper::toModel);
    }

    @Override
    public List<Review> findAll() {
        List<Review> reviews = new ArrayList<>();
        for (ReviewEntity entity : repository.findAll())
            reviews.add(toModel(entity));
        return reviews;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Review> findByUserId(Long userId) {
        return repository.findByUserId(userId).map(ReviewMapper::toModel);
    }

    @Override
    public Optional<Review> findByBookId(Long bookId) {
        return repository.findByBookId(bookId).map(ReviewMapper::toModel);
    }

    @Override
    public Optional<Review> findByBookTitle(String bookTitle) {
        return repository.findByBook_Title(bookTitle).map(ReviewMapper::toModel);
    }

    @Override
    public List<Review> findByRating(Integer rating) {
        return repository.findByRating(rating).stream()
                .map(ReviewMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Review> findByCreatedAt(LocalDate createdAt) {
        return repository.findByCreatedAt(createdAt).stream()
                .map(ReviewMapper::toModel)
                .collect(Collectors.toList());
    }
}