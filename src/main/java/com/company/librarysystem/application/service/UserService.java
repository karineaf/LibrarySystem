package com.company.librarysystem.application.service;


import com.company.librarysystem.domain.model.User;
import com.company.librarysystem.domain.port.out.UserRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserByTelephoneNumber(String telephoneNumber) {
        return userRepository.findByTelephoneNumber(telephoneNumber);
    }

    public List<User> getUsersByBirthDate(LocalDate birthDate) {
        return userRepository.findByBirthDate(birthDate);
    }
}