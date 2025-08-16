package com.company.librarysystem.adapter.in.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@JsonInclude(NON_NULL)
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String telephoneNumber;
    private String address;
    private LocalDate birthDate;
}
