package org.lcwd.user.service.services.impl;

import org.lcwd.user.service.entity.Hotel;
import org.lcwd.user.service.entity.Rating;
import org.lcwd.user.service.entity.User;
import org.lcwd.user.service.exceptions.ResourceNotFoundException;
import org.lcwd.user.service.external.services.HotelService;
import org.lcwd.user.service.repositories.UserRepository;
import org.lcwd.user.service.services.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User saveUser(User user) {
        String randUserID = UUID.randomUUID().toString();
        user.setUserID(randUserID);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userID) {
        User  user =  userRepository.findById(userID).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userID));
        // fetch rating from above user
        // eg: http://localhost:8086/ratings/user/4a37fa6e-e669-4e1b-a025-d75a0004ae31
        logger.atInfo().log("Before calling rating service");
        Rating[] ratings = restTemplate.getForObject("http://RATINGSERICE/ratings/user/" + user.getUserID(), Rating[].class);
        List<Rating> ratingList = Arrays.stream(ratings).toList();
        ratingList = ratingList.stream().map(rating -> {
           // api call to hotel service
            /**
           ResponseEntity<Hotel> forEntity =  restTemplate.getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
            logger.atInfo().log("Recevied Hotel details with stauts code {}", forEntity.getStatusCode());
            rating.setHotel(forEntity.getBody());
             */
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return  user;
    }

    @Override
    public boolean deleteUser(String userID) {
        return false;
    }

    @Override
    public boolean updateUser(String userID) {
        return false;
    }
}
