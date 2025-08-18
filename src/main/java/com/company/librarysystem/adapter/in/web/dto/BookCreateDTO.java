package com.company.librarysystem.adapter.in.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@JsonInclude(NON_NULL)
public class BookCreateDTO {
    private String title;
    private String description;
    @JsonProperty("pages_number")
    private Integer pagesNumber;
    @JsonProperty("release_date")
    private LocalDate releaseDate;
    private String genre;
    @JsonProperty("target_audience")
    private String targetAudience;
    @JsonProperty("authors_ids")
    private List<Long> authorIds;
}
