package com.company.librarysystem.infra.persistence.repository;

import com.company.librarysystem.infra.persistence.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {
}