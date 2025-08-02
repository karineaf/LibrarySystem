package com.company.librarysystem.adapter.persistence.repository;

import com.company.librarysystem.adapter.persistence.entity.AuthorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepositoryJpa extends CrudRepository<AuthorEntity, Long> {
}
