package org.lcwd.user.service.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    private String hotelId;
    private String userId;
    private String ratingId;
    private int rating;
    private String feedback;

    private Hotel hotel;
}
