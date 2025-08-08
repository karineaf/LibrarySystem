package com.company.librarysystem.adapter.in.web.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReservationDTO {
    private Long id;
    private Long userId;
    private Long bookId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}
