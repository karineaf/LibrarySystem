package com.company.librarysystem.adapter.persistence.repository;

import com.company.librarysystem.adapter.persistence.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositoryJpa extends CrudRepository<BookEntity, Long> {
}