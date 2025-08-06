package com.company.librarysystem.adapter.in.web.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationDTO {
    private Long id;
    private Long userId;
    private Long bookId;
    private LocalDate reservationDate;
    private String status;
}
