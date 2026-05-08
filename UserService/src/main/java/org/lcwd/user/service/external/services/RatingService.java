package org.lcwd.user.service.external.services;

import org.lcwd.user.service.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "RATINGSERICE")
public interface RatingService {

    // get
    @GetMapping ("/ratings/{ratingId}")
    public Rating getRating(@PathVariable String ratingId);

    // post
    @PostMapping("/ratings")
    public Rating createRating(Rating values);

    // put
    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable("ratingId") String retingId, Rating rating);

     // delete
    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable("ratingId") String retingId);
}
