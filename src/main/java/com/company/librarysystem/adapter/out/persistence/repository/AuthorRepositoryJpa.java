package com.company.librarysystem.adapter.out.persistence.repository;

import com.company.librarysystem.adapter.out.persistence.entity.AuthorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepositoryJpa extends CrudRepository<AuthorEntity, Long> {
    @Query("""
        SELECT a
        FROM author a
            WHERE LOWER(REPLACE(a.name, ' ', '')) LIKE LOWER(REPLACE(CONCAT(:name, '%'), ' ', ''))
        """)
    List<AuthorEntity> findByName(@Param("name") String name);
    List<AuthorEntity> findByBooks_Id(Long bookId);
    List<AuthorEntity> findByBooks_Title(String bookTitle);
}
