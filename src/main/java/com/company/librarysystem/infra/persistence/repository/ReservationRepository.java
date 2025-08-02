package com.company.librarysystem.infra.persistence.repository;

import com.company.librarysystem.infra.persistence.entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {
}
