package com.company.librarysystem.infra.persistence.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "user")
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