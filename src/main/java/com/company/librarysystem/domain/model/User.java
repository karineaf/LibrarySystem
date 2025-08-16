package com.company.librarysystem.domain.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

import static com.company.librarysystem.util.DateUtils.isValidBirthDate;

@Getter
@EqualsAndHashCode
@Builder
public class User {
    private Long id;
    private String name;
    private String email;
    private String telephoneNumber;
    private String address;
    private LocalDate birthDate;

    public User(Long id, @NonNull String name, @NonNull String email, @NonNull String telephoneNumber,
                @NonNull String address, @NonNull LocalDate birthDate) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.birthDate = birthDate;
        validate();
    }

    private void validate() {
        if (name.isBlank() || telephoneNumber.isBlank() || address.isBlank())
            throw new IllegalArgumentException("Attributes cannot be blank");

        if (!isValidBirthDate(birthDate))
            throw new IllegalArgumentException("Birthday cannot be in the future");
    }

    public void changeName(@NonNull String newName) {
        if (newName.isBlank()) throw new IllegalArgumentException("Name cannot be blank");
        this.name = newName;
    }

    public void changeTelephoneNumber(@NonNull String newNumber) {
        if (newNumber.isBlank()) throw new IllegalArgumentException("Telephone number cannot be blank");
        this.telephoneNumber = newNumber;
    }

    public void changeAddress(@NonNull String newAddress) {
        if (newAddress.isBlank()) throw new IllegalArgumentException("Address cannot be blank");
        this.address = newAddress;
    }

    public void changeBirthDate(@NonNull LocalDate newBirthDate) {
        if (!isValidBirthDate(newBirthDate)) throw new IllegalArgumentException("Birth Date cannot be in the future");
        this.birthDate = newBirthDate;
    }

}
