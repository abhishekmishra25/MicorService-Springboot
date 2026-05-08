package org.lcwd.user.service;

import org.junit.jupiter.api.Test;
import org.lcwd.user.service.entity.Rating;
import org.lcwd.user.service.external.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private RatingService ratingService;

    @Test
    void createRating(){
        Rating rating = Rating.builder()
                .hotelId("afb4f9b1-1595-4fb2-9072-8fa3dd16cdd8")
                .userId("6d98517e-d474-433c-8074-ef88e707f938")
                .rating(9)
                .feedback("Good")
                .build();
        Rating savedRating = ratingService.createRating(rating);
        System.out.println(savedRating);
    }

}
