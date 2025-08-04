package com.company.librarysystem.adapter.out.persistence.entity;

import com.company.librarysystem.domain.model.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static com.company.librarysystem.domain.model.enums.ReservationStatus.ACTIVE;
import static com.company.librarysystem.domain.model.enums.ReservationStatus.CANCELLED;
import static lombok.AccessLevel.PROTECTED;


@Entity
@Table(name = "reservation")
@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status = ACTIVE;

    public boolean isActive() {
        return this.status == ACTIVE;
    }

    public void cancel() {
        if (!isActive()) throw new IllegalStateException("Only active reservations can be cancelled");

        this.status = CANCELLED;
    }
}