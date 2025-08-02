package com.company.librarysystem.domain.port.out;

import com.company.librarysystem.domain.model.Reservation;
import com.company.librarysystem.domain.model.Review;
import com.company.librarysystem.domain.model.enums.ReservationStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReviewRepository {
    Review save(Review review);
    Optional<Review> findById(Long id);
    List<Review> findAll();
    void deleteById(Long id);


    Optional<Review> findByUserId(Long id);
    Optional<Review> findByBookId(Long id);
    Optional<Review> findByBookTitle(String bookTitle);
    List<Review> findByRating(Integer rating);
    List<Review> findByCreatedAt(LocalDate createdAt);

}