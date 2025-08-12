package com.company.librarysystem.adapter.out.persistence.entity.mapper;

import com.company.librarysystem.domain.model.Reservation;
import com.company.librarysystem.adapter.out.persistence.entity.ReservationEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationEntityMapper {

    private final BookEntityMapper bookMapper;

    public Reservation toModel(@NonNull ReservationEntity entity) {

        return Reservation.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .book(bookMapper.toModel(entity.getBook()))
                .startDate(entity.getStartDate())
                .status(entity.getStatus())
                .endDate(entity.getEndDate())
                .build();
    }

    public ReservationEntity toEntity(@NonNull Reservation reservation) {
        return ReservationEntity.builder()
                .id(reservation.getId())
                .userId(reservation.getUserId())
                .book(bookMapper.toEntity(reservation.getBook()))
                .startDate(reservation.getStartDate())
                .endDate(reservation.getEndDate())
                .status(reservation.getStatus())
                .build();
    }
}