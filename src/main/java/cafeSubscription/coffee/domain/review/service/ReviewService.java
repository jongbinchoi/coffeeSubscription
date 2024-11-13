package cafeSubscription.coffee.domain.review.service;

import cafeSubscription.coffee.domain.review.DTO.AddReviewRequest;
import cafeSubscription.coffee.domain.review.Review;
import cafeSubscription.coffee.domain.review.custom.Keyword;
import cafeSubscription.coffee.domain.review.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Transactional
    @PreAuthorize("hasRole('customer')")
    public Review save(AddReviewRequest addReviewRequest) {
        return reviewRepository.save(addReviewRequest.toEntity());
    }

    @Transactional
    @PreAuthorize("hasRole('customer')")
    public Review update(Long reviewId, AddReviewRequest request) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + reviewId)); // 예외처리

        review.update(request.getRContent(), request.getRImage());

        return reviewRepository.save(review);
    }

    @Transactional
    @PreAuthorize("hasRole('customer')")
    public void delete(Long reviewId) {
        reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + reviewId));
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }
}
