package com.company.librarysystem.domain.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Genre {
    FICTION,
    NONFICTION,
    MYSTERY,
    FANTASY,
    SCIENCE,
    ROMANCE,
    HORROR,
    BIOGRAPHY,
    HISTORY,
    POETRY,
    COMEDY,
    DRAMA,
    EDUCATIONAL,
    LGBT,
    COOKING,
    CHILDREN,
    YOUNG_ADULT,
    SELF_HELP,
    BUSINESS,
    SPIRITUALITY,
    OTHER,
    UNDEFINED;

    @JsonCreator
    public static Genre fromValue(String value) {
        return Genre.valueOf(value.toUpperCase());
    }
}