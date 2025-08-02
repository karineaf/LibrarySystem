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

    Optional<Reservation> findByUserId(Long id);
    Optional<Reservation> findByBookId(Long id);
    Optional<Reservation> findByBookTitle(String bookTitle);
    List<Reservation> findByStatus(ReservationStatus status);

}