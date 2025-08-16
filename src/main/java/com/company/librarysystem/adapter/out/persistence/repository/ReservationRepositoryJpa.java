package com.company.librarysystem.adapter.out.persistence.repository;

import com.company.librarysystem.adapter.out.persistence.entity.ReservationEntity;
import com.company.librarysystem.domain.model.enums.ReservationStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepositoryJpa extends CrudRepository<ReservationEntity, Long> {

    List<ReservationEntity> findByUserId(Long userId);
    List<ReservationEntity> findByBookId(Long bookId);
    List<ReservationEntity> findByStatus(ReservationStatus status);
    List<ReservationEntity> findByUserIdAndBookIdOrderByStartDateDesc(Long userId, Long bookId);

    @Query("""
            SELECT CASE WHEN COUNT(r) > 0 THEN TRUE ELSE FALSE END
            FROM ReservationEntity r
            WHERE r.book.id = :bookId AND r.status = :status""")
    boolean existsByBookIdAndStatus(Long bookId, ReservationStatus status);

}
