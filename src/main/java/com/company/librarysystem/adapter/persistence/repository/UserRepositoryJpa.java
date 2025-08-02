package com.company.librarysystem.adapter.persistence.repository;

import com.company.librarysystem.adapter.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends CrudRepository<UserEntity, Long> {
}
