package com.company.librarysystem.adapter.in.web.controller;

import com.company.librarysystem.adapter.in.web.dto.AuthorDTO;
import com.company.librarysystem.adapter.in.web.dto.ReservationCreateDTO;
import com.company.librarysystem.adapter.in.web.dto.ReservationDTO;
import com.company.librarysystem.adapter.in.web.dto.mapper.ReservationDTOMapper;
import com.company.librarysystem.application.service.ReservationService;
import com.company.librarysystem.domain.model.Reservation;
import com.company.librarysystem.domain.model.enums.ReservationStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.*;


@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService service;
    private final ReservationDTOMapper mapper;

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> findAllReservations() {
        List<ReservationDTO> dtoList = service.findAllReservations().stream()
                .map(mapper::toDTO)
                .collect(toList());
        return ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable Long id) {
        return service.findById(id)
                .map(reservation -> ok(mapper.toDTO(reservation)))
                .orElse(notFound().build());
    }

    @GetMapping("/search/by_user/{user_id}")
    public ResponseEntity<List<ReservationDTO>> getReservationsByUser(@PathVariable("user_id") Long userId) {
        List<ReservationDTO> reservations = service.findByUserId(userId)
                .stream()
                .map(mapper::toDTO)
                .toList();

        if (reservations.isEmpty()) return noContent().build();
        return ok(reservations);
    }

    @GetMapping("/search/by_book/{book_id}")
    public ResponseEntity<List<ReservationDTO>> getReservationsByBook(@PathVariable("book_id") Long bookId) {
        List<ReservationDTO> reservations = service.findByBookId(bookId)
                .stream()
                .map(mapper::toDTO)
                .toList();

        if (reservations.isEmpty()) return noContent().build();
        return ok(reservations);
    }

    @GetMapping("/search/by_status")
    public ResponseEntity<List<ReservationDTO>> getReservationsByStatus(@RequestParam String status) {
        List<ReservationDTO> reservations = service.findByStatus(ReservationStatus.valueOf(status))
                .stream()
                .map(mapper::toDTO)
                .toList();

        if (reservations.isEmpty()) return noContent().build();
        return ok(reservations);
    }


    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationCreateDTO dto) {
        return new ResponseEntity<>(
                mapper.toDTO(service.createReservation(dto.getUserId(), dto.getBookId(), dto.getPerDays())), CREATED);
    }

    @PutMapping("/{id}/finish")
    public ResponseEntity<ReservationDTO> finishReservation(@PathVariable Long id) {
        return ok(mapper.toDTO(service.finishReservation(id)));
    }
}