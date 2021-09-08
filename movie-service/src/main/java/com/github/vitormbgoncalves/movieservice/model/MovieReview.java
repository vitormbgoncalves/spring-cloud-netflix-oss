package com.github.vitormbgoncalves.movieservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class MovieReview extends RepresentationModel<MovieReview> {
  private Long Id;
  private Long movieId;
  private String review;
  private String authorName;
}
