package org.lcwd.rating.service.impl;

import org.lcwd.rating.entity.Rating;
import org.lcwd.rating.exception.ResourceNotFoundException;
import org.lcwd.rating.repositories.RatingRepo;
import org.lcwd.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Rating create(Rating rating) {
        rating.setRatingId(UUID.randomUUID().toString());
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getRatingByHotelId(String id) {
        return ratingRepo.findByHotelId(id);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
         return ratingRepo.findByUserId(userId);
    }
}
