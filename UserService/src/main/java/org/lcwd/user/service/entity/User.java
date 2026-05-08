package org.lcwd.user.service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_user")
public class User {
    @Id
    @Column(name = "ID")
    private String userID;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;

    @Column(name = "ABOUT", length = 500)
    private String about;
    // other columns you want to add

    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
