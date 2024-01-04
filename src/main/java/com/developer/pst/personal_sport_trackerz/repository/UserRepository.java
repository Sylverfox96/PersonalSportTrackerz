package com.developer.pst.personal_sport_trackerz.repository;

import com.developer.pst.personal_sport_trackerz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
