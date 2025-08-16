package com.company.librarysystem.domain.port.out;

import com.company.librarysystem.domain.model.Reservation;
import com.company.librarysystem.domain.model.enums.ReservationStatus;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    Reservation save(Reservation reservation);
    Optional<Reservation> findById(Long id);
    List<Reservation> findAll();
    void deleteById(Long id);

    List<Reservation> findByUserId(Long id);
    List<Reservation> findByBookId(Long id);
    List<Reservation> findByStatus(ReservationStatus status);
    List<Reservation> findByUserIdAndBookIdOrderByStartDateDesc(Long userId, Long bookId);
    boolean existsActiveReservationForBook(Long bookId);

}