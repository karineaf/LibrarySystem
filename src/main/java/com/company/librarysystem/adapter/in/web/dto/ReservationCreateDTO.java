package com.company.librarysystem.adapter.in.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@JsonInclude(NON_NULL)
public class ReservationCreateDTO {
    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("book_id")
    private Long bookId;

    @JsonProperty("per_days")
    private Integer perDays;
}
