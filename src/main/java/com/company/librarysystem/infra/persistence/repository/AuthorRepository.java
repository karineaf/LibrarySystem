package com.company.librarysystem.infra.persistence.repository;

import com.company.librarysystem.infra.persistence.entity.AuthorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
}
