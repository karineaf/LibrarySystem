package com.company.librarysystem.adapter.out.persistence.repository;

import com.company.librarysystem.adapter.out.persistence.entity.ReviewEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepositoryJpa extends CrudRepository<ReviewEntity, Long> {
    Optional<ReviewEntity> findByUserId(Long userId);
    Optional<ReviewEntity> findByBookId(Long bookId);
    Optional<ReviewEntity> findByBook_Title(String bookTitle);
    List<ReviewEntity> findByRating(Integer rating);
    List<ReviewEntity> findByCreatedAt(LocalDate createdAt);
}
