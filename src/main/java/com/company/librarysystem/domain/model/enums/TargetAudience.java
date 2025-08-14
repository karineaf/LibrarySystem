package com.company.librarysystem.domain.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TargetAudience {
    CHILDREN,
    PRE_TEEN,
    TEEN,
    YOUNG_ADULT,
    ADULT,
    OTHER,
    UNDEFINED;

    @JsonCreator
    public static TargetAudience fromValue(String value) {
        return TargetAudience.valueOf(value.toUpperCase());
    }
}
