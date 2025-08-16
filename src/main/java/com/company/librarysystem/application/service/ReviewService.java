package com.company.librarysystem.application.service;

import com.company.librarysystem.domain.model.Book;
import com.company.librarysystem.domain.model.Review;
import com.company.librarysystem.domain.port.out.BookRepository;
import com.company.librarysystem.domain.port.out.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.time.LocalDate.now;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final BookRepository bookRepository;

    public Review createReview(Long userId, Long bookId, Integer rating, String comment) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        return reviewRepository.save(Review.builder()
                .userId(userId)
                .book(book)
                .rating(rating)
                .comment(comment)
                .createdAt(now())
                .build());
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