package org.lcwd.rating.repositories;

import org.lcwd.rating.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepo extends JpaRepository<Rating, String> {
    // for custom query we can write here

    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);
}
