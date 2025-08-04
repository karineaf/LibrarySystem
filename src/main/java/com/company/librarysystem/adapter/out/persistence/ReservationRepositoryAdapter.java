package com.company.librarysystem.adapter.out.persistence;

import com.company.librarysystem.adapter.out.persistence.entity.ReservationEntity;
import com.company.librarysystem.adapter.out.persistence.entity.mapper.ReservationMapper;
import com.company.librarysystem.adapter.out.persistence.repository.ReservationRepositoryJpa;
import com.company.librarysystem.domain.model.Reservation;
import com.company.librarysystem.domain.model.enums.ReservationStatus;
import com.company.librarysystem.domain.port.out.ReservationRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.company.librarysystem.adapter.out.persistence.entity.mapper.ReservationMapper.*;

@RequiredArgsConstructor
public class ReservationRepositoryAdapter implements ReservationRepository {

    private final ReservationRepositoryJpa repository;

    @Override
    public Reservation save(Reservation reservation) {
        return toModel(repository.save(toEntity(reservation)));
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return repository.findById(id)
                .map(ReservationMapper::toModel);
    }

    @Override
    public List<Reservation> findAll() {
        List<Reservation> reservations = new ArrayList<>();
        for (ReservationEntity entity : repository.findAll())
            reservations.add(toModel(entity));
        return reservations;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Reservation> findByUserId(Long userId) {
        return repository.findByUserId(userId)
                .map(ReservationMapper::toModel);
    }

    @Override
    public Optional<Reservation> findByBookId(Long bookId) {
        return repository.findByBookId(bookId)
                .map(ReservationMapper::toModel);
    }

    @Override
    public Optional<Reservation> findByBookTitle(String bookTitle) {
        return repository.findByBook_Title(bookTitle)
                .map(ReservationMapper::toModel);
    }

    @Override
    public List<Reservation> findByStatus(ReservationStatus status) {
        List<Reservation> reservations = new ArrayList<>();
        for (var entity : repository.findByStatus(status)) {
            reservations.add(toModel(entity));
        }
        return reservations;
    }
}

