package org.lcwd.rating.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @Column(name = "ID")
    private String ratingId;

    @Column(name = "HOTEL_ID", nullable = false)
    private String hotelId;

    @Column( name = "USER_ID", nullable = false)
    private String userId;

    @Column(name = "RATING", nullable = false)
    private int rating;

    @Column(name = "FEEDBACK")
    private String feedback;

}
