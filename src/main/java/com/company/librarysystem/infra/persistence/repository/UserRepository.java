package com.company.librarysystem.infra.persistence.repository;

import com.company.librarysystem.infra.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
