package com.company.librarysystem.adapter.in.web.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String telephoneNumber;
    private String address;
    private LocalDate birthDate;
}
