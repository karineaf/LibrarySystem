package com.company.librarysystem.adapter.out.persistence.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(name = "telephone_number", nullable = false)
    private String telephoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
}