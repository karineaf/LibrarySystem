package com.company.librarysystem.adapter.out.persistence.repository;

import com.company.librarysystem.adapter.out.persistence.entity.ReservationEntity;
import com.company.librarysystem.domain.model.enums.ReservationStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepositoryJpa extends CrudRepository<ReservationEntity, Long> {

    Optional<ReservationEntity> findByUserId(Long userId);
    Optional<ReservationEntity> findByBookId(Long bookId);
    Optional<ReservationEntity> findByBook_Title(String bookTitle);
    List<ReservationEntity> findByStatus(ReservationStatus status);
}
