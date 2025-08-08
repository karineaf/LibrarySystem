package com.company.librarysystem.adapter.in.web.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String telephoneNumber;
    private String address;
    private LocalDate birthDate;
}
