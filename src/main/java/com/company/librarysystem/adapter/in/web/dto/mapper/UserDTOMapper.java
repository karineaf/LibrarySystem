package com.company.librarysystem.adapter.in.web.dto.mapper;

import com.company.librarysystem.adapter.in.web.dto.UserDTO;
import com.company.librarysystem.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDTOMapper {
    public UserDTO toDTO(User user) {
        if (user == null) return null;

        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .telephoneNumber(user.getTelephoneNumber())
                .address(user.getAddress())
                .birthDate(user.getBirthDate())
                .build();
    }

    public User toModel(UserDTO dto) {
        if (dto == null) return null;

        return User.builder()
                .id(dto.getId() != null ? dto.getId() : null)
                .name(dto.getName())
                .email(dto.getEmail())
                .telephoneNumber(dto.getTelephoneNumber())
                .address(dto.getAddress())
                .birthDate(dto.getBirthDate())
                .build();
    }
}
