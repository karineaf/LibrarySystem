package com.company.librarysystem.adapter.out.persistence.entity.mapper;

import com.company.librarysystem.domain.model.Reservation;
import com.company.librarysystem.adapter.out.persistence.entity.ReservationEntity;
import lombok.NonNull;

public class ReservationMapper {

    public static Reservation toModel(@NonNull ReservationEntity entity) {

        return Reservation.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .book(BookMapper.toModel(entity.getBook()))
                .startDate(entity.getStartDate())
                .status(entity.getStatus())
                .endDate(entity.getEndDate())
                .build();
    }

    public static ReservationEntity toEntity(@NonNull Reservation reservation) {
        return ReservationEntity.builder()
                .id(reservation.getId())
                .userId(reservation.getUserId())
                .book(BookMapper.toEntity(reservation.getBook()))
                .startDate(reservation.getStartDate())
                .endDate(reservation.getEndDate())
                .status(reservation.getStatus())
                .build();
    }
}