package com.developer.pst.personal_sport_trackerz.repository;

import com.developer.pst.personal_sport_trackerz.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long> {
}
