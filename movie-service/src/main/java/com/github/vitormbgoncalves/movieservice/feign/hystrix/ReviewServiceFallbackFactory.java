package com.github.vitormbgoncalves.movieservice.feign.hystrix;

import com.github.vitormbgoncalves.movieservice.feign.ReviewsFeignClient;
import com.github.vitormbgoncalves.movieservice.model.MovieReview;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ReviewServiceFallbackFactory implements FallbackFactory<ReviewsFeignClient> {
  private static final Logger LOGGER = LoggerFactory.getLogger(ReviewServiceFallbackFactory.class);

  @Override
  public ReviewsFeignClient create(Throwable throwable) {
    return new ReviewsFeignClient() {
      @Override
      public CollectionModel<MovieReview> getMovieReviews(Long movieId) {
        LOGGER.error("Error occurred trying to fetch reviews from review service", throwable);
        return new CollectionModel<>(Collections.emptyList());
      }
    };
  }
}
