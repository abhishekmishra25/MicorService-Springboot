package org.lcwd.hotel.contoller;

import org.lcwd.hotel.entity.Hotel;
import org.lcwd.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // create
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    // getSingle
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String id){
        Hotel hotel = hotelService.get(id);
        return ResponseEntity.ok(hotel);
    }

    // getAll
    @GetMapping
    public ResponseEntity<?> getAllHotel(){
        return ResponseEntity.ok(hotelService.getAll());
    }
}
