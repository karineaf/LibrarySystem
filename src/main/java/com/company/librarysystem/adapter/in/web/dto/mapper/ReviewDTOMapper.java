package com.company.librarysystem.adapter.in.web.dto.mapper;

import com.company.librarysystem.adapter.in.web.dto.ReviewDTO;
import com.company.librarysystem.domain.model.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewDTOMapper {
    ReviewDTO toDTO(Review review);
    Review toModel(ReviewDTO dto);
}
