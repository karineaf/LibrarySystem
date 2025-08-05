package com.company.librarysystem.adapter.in.web.dto.mapper;

import com.company.librarysystem.adapter.in.web.dto.UserDTO;
import com.company.librarysystem.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {
    UserDTO toDTO(User user);
    User toModel(UserDTO dto);
}
