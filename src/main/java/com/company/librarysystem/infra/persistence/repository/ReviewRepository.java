package com.company.librarysystem.infra.persistence.repository;

import com.company.librarysystem.infra.persistence.entity.ReviewEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<ReviewEntity, Long> {
}
