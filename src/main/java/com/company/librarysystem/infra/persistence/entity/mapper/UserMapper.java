package com.company.librarysystem.infra.persistence.entity.mapper;

import com.company.librarysystem.domain.model.User;
import com.company.librarysystem.infra.persistence.entity.UserEntity;
import lombok.NonNull;

public class UserMapper {

    public static User toModel(@NonNull UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .telephoneNumber(entity.getTelephoneNumber())
                .address(entity.getAddress())
                .birthDate(entity.getBirthDate())
                .build();
    }

    public static UserEntity toEntity(@NonNull User domain) {
        return UserEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .email(domain.getEmail())
                .telephoneNumber(domain.getTelephoneNumber())
                .address(domain.getAddress())
                .birthDate(domain.getBirthDate())
                .build();
    }
}
