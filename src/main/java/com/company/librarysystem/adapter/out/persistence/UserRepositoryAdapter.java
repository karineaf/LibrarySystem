package com.company.librarysystem.adapter.out.persistence;

import com.company.librarysystem.adapter.out.persistence.entity.ReviewEntity;
import com.company.librarysystem.adapter.out.persistence.entity.UserEntity;
import com.company.librarysystem.adapter.out.persistence.entity.mapper.UserMapper;
import com.company.librarysystem.adapter.out.persistence.repository.UserRepositoryJpa;
import com.company.librarysystem.domain.model.Review;
import com.company.librarysystem.domain.model.User;
import com.company.librarysystem.domain.port.out.UserRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.company.librarysystem.adapter.out.persistence.entity.mapper.ReviewMapper.toModel;

@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final UserRepositoryJpa repository;

    @Override
    public User save(User model) {
        UserEntity entity = UserMapper.toEntity(model);
        entity = repository.save(entity);
        return UserMapper.toModel(entity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id).map(UserMapper::toModel);
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        for (UserEntity entity : repository.findAll())
            users.add(toModel(entity));
        return users;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<User> findByName(String name) {
        return repository.findByName(name).map(UserMapper::toModel);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email).map(UserMapper::toModel);
    }

    @Override
    public Optional<User> findByTelephoneNumber(String telephoneNumber) {
        return repository.findByTelephoneNumber(telephoneNumber).map(UserMapper::toModel);
    }

    @Override
    public List<User> findByBirthDate(LocalDate birthDate) {
        return repository.findByBirthDate(birthDate).stream()
                .map(UserMapper::toModel)
                .collect(Collectors.toList());
    }
}