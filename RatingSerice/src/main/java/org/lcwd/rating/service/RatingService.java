package org.lcwd.rating.service;

import org.lcwd.rating.entity.Rating;

import java.util.List;

public interface RatingService {

    // create rating
    Rating create(Rating rating);

    // view one rating
    List<Rating> getRatingByHotelId(String hotelId);

    // view all rating
    List<Rating> getAllRating();

    // update one rating
    List<Rating> getRatingByUserId(String userId);

}
