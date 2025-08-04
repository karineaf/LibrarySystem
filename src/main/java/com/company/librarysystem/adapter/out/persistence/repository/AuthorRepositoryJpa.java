package com.company.librarysystem.adapter.out.persistence.repository;

import com.company.librarysystem.adapter.out.persistence.entity.AuthorEntity;
import com.company.librarysystem.domain.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepositoryJpa extends CrudRepository<AuthorEntity, Long> {
    Optional<AuthorEntity> findByName(String name);
    List<AuthorEntity> findByBooks_Id(Long bookId);
    List<AuthorEntity> findByBooks_Title(String bookTitle);
}
