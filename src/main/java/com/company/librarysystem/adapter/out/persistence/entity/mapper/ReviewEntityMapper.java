package com.company.librarysystem.adapter.out.persistence.entity.mapper;
import com.company.librarysystem.domain.model.Review;
import com.company.librarysystem.adapter.out.persistence.entity.ReviewEntity;
import lombok.NonNull;

public class ReviewEntityMapper {
    public static Review toModel(@NonNull ReviewEntity entity) {
        return Review.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .book(BookEntityMapper.toModel(entity.getBook()))
                .rating(entity.getRating())
                .comment(entity.getComment())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public static ReviewEntity toEntity(@NonNull Review domain) {
        return ReviewEntity.builder()
                .id(domain.getId())
                .userId(domain.getUserId())
                .book(BookEntityMapper.toEntity(domain.getBook()))
                .rating(domain.getRating())
                .comment(domain.getComment())
                .createdAt(domain.getCreatedAt())
                .build();
    }

}
