package org.lcwd.hotel.reposotories;

import org.lcwd.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel, String>  {
    // for custume query we can write here

}
