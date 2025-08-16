package com.company.librarysystem.adapter.out.persistence;

import com.company.librarysystem.adapter.out.persistence.entity.ReservationEntity;
import com.company.librarysystem.adapter.out.persistence.entity.mapper.ReservationEntityMapper;
import com.company.librarysystem.adapter.out.persistence.repository.ReservationRepositoryJpa;
import com.company.librarysystem.domain.model.Reservation;
import com.company.librarysystem.domain.model.enums.ReservationStatus;
import com.company.librarysystem.domain.port.out.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.company.librarysystem.domain.model.enums.ReservationStatus.ACTIVE;
import static java.util.stream.Collectors.*;

@RequiredArgsConstructor
@Repository
public class ReservationRepositoryAdapter implements ReservationRepository {

    private final ReservationRepositoryJpa repository;
    private final ReservationEntityMapper mapper;

    @Override
    public Reservation save(Reservation reservation) {

        return mapper.toModel(repository.save(mapper.toEntity(reservation)));
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toModel);
    }

    @Override
    public List<Reservation> findAll() {
        List<Reservation> reservations = new ArrayList<>();
        for (ReservationEntity entity : repository.findAll())
            reservations.add(mapper.toModel(entity));
        return reservations;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Reservation> findByUserId(Long userId) {
        return repository.findByUserId(userId)
                .stream()
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public List<Reservation> findByBookId(Long bookId) {
        return repository.findByBookId(bookId)
                .stream()
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public List<Reservation> findByStatus(ReservationStatus status) {
        List<Reservation> reservations = new ArrayList<>();
        for (var entity : repository.findByStatus(status)) {
            reservations.add(mapper.toModel(entity));
        }
        return reservations;
    }

    @Override
    public boolean existsActiveReservationForBook(Long bookId) {
        return repository.existsByBookIdAndStatus(bookId, ACTIVE);
    }

    @Override
    public List<Reservation> findByUserIdAndBookIdOrderByStartDateDesc(Long userId, Long bookId) {
        return repository.findByUserIdAndBookIdOrderByStartDateDesc(userId, bookId)
                .stream()
                .map(mapper::toModel)
                .collect(toList());
    }
}

