package com.company.librarysystem.adapter.out.persistence.repository;

import com.company.librarysystem.adapter.out.persistence.entity.BookEntity;
import com.company.librarysystem.domain.model.enums.Genre;
import com.company.librarysystem.domain.model.enums.TargetAudience;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepositoryJpa extends CrudRepository<BookEntity, Long> {
    Optional<BookEntity> findByTitle(String title);
    List<BookEntity> findByReleaseDate(LocalDate releaseDate);
    List<BookEntity> findByGenre(Genre genre);
    List<BookEntity> findByTargetAudience(TargetAudience targetAudience);
    List<BookEntity> findByAuthors_Id(Long authorId);
}