package com.company.librarysystem.adapter.in.web.controller;

import com.company.librarysystem.adapter.in.web.dto.ReservationDTO;
import com.company.librarysystem.adapter.in.web.dto.mapper.ReservationDTOMapper;
import com.company.librarysystem.application.service.ReservationService;
import com.company.librarysystem.domain.model.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.*;


@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService service;
    private final ReservationDTOMapper dtoMapper;

    @PostMapping
    public ResponseEntity<ReservationDTO> create(@RequestBody ReservationDTO dto) {
        Reservation reservation = dtoMapper.toModel(dto);
        Reservation saved = service.createReservation(reservation);
        return ok(dtoMapper.toDTO(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> findById(@PathVariable Long id) {
        return service.getReservationById(id)
                .map(dtoMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> findAll() {
        List<ReservationDTO> list = service.getAllReservations()
                .stream()
                .map(dtoMapper::toDTO)
                .collect(toList());
        return ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteReservation(id);
        return noContent().build();
    }
}