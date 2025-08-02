package com.company.librarysystem.application.service;

import com.company.librarysystem.domain.model.Review;
import com.company.librarysystem.domain.port.out.ReviewRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public Optional<Review> getReviewByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    public Optional<Review> getReviewByBookId(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    public Optional<Review> getReviewByBookTitle(String bookTitle) {
        return reviewRepository.findByBookTitle(bookTitle);
    }

    public List<Review> getReviewsByRating(Integer rating) {
        return reviewRepository.findByRating(rating);
    }

    public List<Review> getReviewsByCreatedAt(LocalDate createdAt) {
        return reviewRepository.findByCreatedAt(createdAt);
    }
}