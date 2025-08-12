package com.company.librarysystem.adapter.out.persistence.entity.mapper;
import com.company.librarysystem.domain.model.Review;
import com.company.librarysystem.adapter.out.persistence.entity.ReviewEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewEntityMapper {
    private final BookEntityMapper mapper;

    public Review toModel(@NonNull ReviewEntity entity) {
        return Review.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .book(mapper.toModel(entity.getBook()))
                .rating(entity.getRating())
                .comment(entity.getComment())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public ReviewEntity toEntity(@NonNull Review domain) {
        return ReviewEntity.builder()
                .id(domain.getId())
                .userId(domain.getUserId())
                .book(mapper.toEntity(domain.getBook()))
                .rating(domain.getRating())
                .comment(domain.getComment())
                .createdAt(domain.getCreatedAt())
                .build();
    }

}
