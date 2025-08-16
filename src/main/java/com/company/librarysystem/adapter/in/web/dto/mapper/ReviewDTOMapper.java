package com.company.librarysystem.adapter.in.web.dto.mapper;

import com.company.librarysystem.adapter.in.web.dto.ReviewCreateDTO;
import com.company.librarysystem.adapter.in.web.dto.ReviewDTO;
import com.company.librarysystem.domain.model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewDTOMapper {
    public ReviewDTO toDTO(Review review) {
        if (review == null) return null;

        return ReviewDTO.builder()
                .id(review.getId())
                .userId(review.getUserId())
                .book(review.getBook())
                .rating(review.getRating())
                .comment(review.getComment())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public Review toModel(ReviewCreateDTO dto) {
        if (dto == null) return null;

        return Review.builder()
                .userId(dto.getUserId())
                .rating(dto.getRating())
                .comment(dto.getComment())
                .build();
    }

}
