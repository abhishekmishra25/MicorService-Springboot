package org.lcwd.user.service.repositories;

import org.lcwd.user.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    //write custom methods or query
}
