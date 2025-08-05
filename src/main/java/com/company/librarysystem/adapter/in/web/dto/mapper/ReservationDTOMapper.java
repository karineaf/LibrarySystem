package com.company.librarysystem.adapter.in.web.dto.mapper;

import com.company.librarysystem.adapter.in.web.dto.ReservationDTO;
import com.company.librarysystem.domain.model.Reservation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationDTOMapper {
    ReservationDTO toDTO(Reservation reservation);
    Reservation toModel(ReservationDTO dto);
}
