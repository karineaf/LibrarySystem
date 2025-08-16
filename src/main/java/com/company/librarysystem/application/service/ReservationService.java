package com.company.librarysystem.application.service;


import com.company.librarysystem.domain.model.Book;
import com.company.librarysystem.domain.model.Reservation;
import com.company.librarysystem.domain.model.enums.ReservationStatus;
import com.company.librarysystem.domain.port.out.BookRepository;
import com.company.librarysystem.domain.port.out.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.company.librarysystem.domain.model.enums.ReservationStatus.*;
import static java.lang.String.format;
import static java.time.LocalDate.now;

@RequiredArgsConstructor
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final BookRepository bookRepository;

    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    public List<Reservation> findByUserId(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    public List<Reservation> findByBookId(Long bookId) {
        return reservationRepository.findByBookId(bookId);
    }

    public List<Reservation> findByStatus(ReservationStatus status) {
        return reservationRepository.findByStatus(status);
    }

    public Reservation createReservation(Long userId, Long bookId, Integer perDays) {

        if (perDays > 30)
            throw new IllegalArgumentException("Reservations can last a maximum of 30 days");

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        if (reservationRepository.existsActiveReservationForBook(book.getId()))
            throw new IllegalStateException(format("Book '%s' is already reserved", book.getTitle()));

        List<Reservation> userReservations = reservationRepository
                .findByUserIdAndBookIdOrderByStartDateDesc(userId, bookId);

        if (!userReservations.isEmpty() && userReservations.size() >= 2) {
            Reservation lastReservation = userReservations.getFirst();
            if (now().isBefore(lastReservation.getEndDate().plusDays(10)))
                throw new IllegalStateException("Must wait at least 10 days before reserving this book again");
        }

        return reservationRepository.save(Reservation.builder()
                .userId(userId)
                .book(book)
                .startDate(now())
                .endDate(now().plusDays(perDays))
                .status(ACTIVE)
                .build());
    }

    public Reservation finishReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found"));

        if (reservation.getStatus() != ACTIVE)
            throw new IllegalStateException("Reservation Status must be ACTIVE to finish");

        reservation.finish();
        return reservationRepository.save(reservation);
    }

}