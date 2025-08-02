package com.company.librarysystem.adapter.persistence.repository;

import com.company.librarysystem.adapter.persistence.entity.ReviewEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepositoryJpa extends CrudRepository<ReviewEntity, Long> {
}
