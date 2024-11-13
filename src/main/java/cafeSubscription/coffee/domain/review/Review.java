package cafeSubscription.coffee.domain.review;


import cafeSubscription.coffee.domain.cafe.Cafe;
import cafeSubscription.coffee.domain.review.custom.Keyword;
import cafeSubscription.coffee.domain.review.custom.KeywordConverter;
import cafeSubscription.coffee.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    private Cafe cafe;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String rContent;

//    @Convert(converter = KeywordConverter.class)
//    private Keyword keyword;

    @Column(nullable = false)
    private String rImage;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Integer reportCount;

    public void update(String rContent, String rImage) {
        this.rContent = rContent;
//        this.keyword = keyword;
        this.rImage = rImage;
    }
}
