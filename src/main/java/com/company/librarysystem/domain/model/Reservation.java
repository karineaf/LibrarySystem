package com.company.librarysystem.domain.model;

import com.company.librarysystem.domain.model.enums.ReservationStatus;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

import static com.company.librarysystem.domain.model.enums.ReservationStatus.*;
import static com.company.librarysystem.util.DateUtils.isValidRange;
import static java.time.LocalDate.now;

@Getter
@EqualsAndHashCode
@Builder
public class Reservation {
    private final Long id;
    private final Long userId;
    private final Book book;
    private final LocalDate startDate;
    private LocalDate endDate;
    private ReservationStatus status;

    public Reservation(Long id, @NonNull Long userId, @NonNull Book book,
                       @NonNull LocalDate startDate, @NonNull LocalDate endDate, ReservationStatus status) {

        if (!isValidRange(startDate,endDate)) throw new IllegalArgumentException("End date cannot be before start date");

        this.id = id;
        this.userId = userId;
        this.book = book;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = (status != null) ? status : ACTIVE;
    }

    public boolean isActive() {
        return status == ACTIVE;
    }

    public void finish() {
        if (!isActive())
            throw new IllegalStateException("Only active reservations can be finished");

        this.status = FINISHED;
        this.endDate = now();
    }


}




