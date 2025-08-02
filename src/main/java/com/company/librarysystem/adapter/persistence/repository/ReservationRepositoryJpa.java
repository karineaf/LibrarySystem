package com.company.librarysystem.adapter.persistence.repository;

import com.company.librarysystem.adapter.persistence.entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepositoryJpa extends CrudRepository<ReservationEntity, Long> {
}
