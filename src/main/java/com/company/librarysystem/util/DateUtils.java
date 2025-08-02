package com.company.librarysystem.util;

import java.time.LocalDate;

import static java.time.LocalDate.now;

public class DateUtils {

    private DateUtils() {
    }

    public static boolean isValidRange(LocalDate start, LocalDate end) {
        if (start == null || end == null) return false;
        return !end.isBefore(start);
    }

    public static boolean isValidBirthDate(LocalDate birthDate) {
        return !birthDate.isAfter(now());
    }
}
