package com.github.vitormbgoncalves.movieservice.feign.hystrix;

import com.github.vitormbgoncalves.movieservice.feign.ReviewsFeignClient;
import com.github.vitormbgoncalves.movieservice.model.MovieReview;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ReviewServiceFallback implements ReviewsFeignClient {

  @Override
  public CollectionModel<MovieReview> getMovieReviews(Long movieId) {
    return new CollectionModel<>(Collections.emptyList());
  }
}
