package com.company.librarysystem.adapter.in.web.dto.mapper;

import com.company.librarysystem.adapter.in.web.dto.ReservationDTO;
import com.company.librarysystem.domain.model.Reservation;
import com.company.librarysystem.domain.model.enums.ReservationStatus;

import static com.company.librarysystem.domain.model.enums.ReservationStatus.valueOf;
import static java.lang.String.valueOf;

public class ReservationDTOMapper {
    public ReservationDTO toDTO(Reservation reservation) {
        if (reservation == null) return null;

        return ReservationDTO.builder()
                .id(reservation.getId())
                .userId(reservation.getUserId())
                .bookId(reservation.getBook().getId())
                .startDate(reservation.getStartDate())
                .endDate(reservation.getEndDate())
                .status(valueOf(reservation.getStatus()))
                .build();
    }

    public Reservation toModel(ReservationDTO dto) {
        if (dto == null) return null;

        return Reservation.builder()
                .id(dto.getId())
                .userId(dto.getUserId())
                //.book()
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .status(valueOf(dto.getStatus()))
                .build();
    }
}
