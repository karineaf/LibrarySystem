package com.company.librarysystem.adapter.out.persistence.entity.mapper;
import com.company.librarysystem.domain.model.Review;
import com.company.librarysystem.adapter.out.persistence.entity.ReviewEntity;
import lombok.NonNull;

public class ReviewMapper {
    public static Review toModel(@NonNull ReviewEntity entity) {
        return Review.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .book(BookMapper.toModel(entity.getBook()))
                .rating(entity.getRating())
                .comment(entity.getComment())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public static ReviewEntity toEntity(@NonNull Review domain) {
        return ReviewEntity.builder()
                .id(domain.getId())
                .userId(domain.getUserId())
                .book(BookMapper.toEntity(domain.getBook()))
                .rating(domain.getRating())
                .comment(domain.getComment())
                .createdAt(domain.getCreatedAt())
                .build();
    }

}
