package com.company.librarysystem.domain.port.out;

import com.company.librarysystem.domain.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    void deleteById(Long id);

    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findByTelephoneNumber(String telephoneNumber);
    List<User> findByBirthDate(LocalDate birthDate);


}