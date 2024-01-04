package com.developer.pst.personal_sport_trackerz.service;

import com.developer.pst.personal_sport_trackerz.dto.CoursesDTO;
import com.developer.pst.personal_sport_trackerz.entity.Course;
import com.developer.pst.personal_sport_trackerz.entity.User;
import com.developer.pst.personal_sport_trackerz.repository.CourseRepository;
import com.developer.pst.personal_sport_trackerz.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseService(final CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public List<CoursesDTO> findAll() {
        return courseRepository.findAll()
                .stream()
                .filter(course -> course.getNoOfAvailablePlaces() > 0)
                .map(course -> mapToDTO(course, new CoursesDTO()))
                .collect(Collectors.toList());
    }

    private CoursesDTO mapToDTO(final Course course, final CoursesDTO coursesDTO) {
        coursesDTO.setId(course.getId());
        coursesDTO.setLocation(course.getLocalisation());
        coursesDTO.setDate(course.getDate());
        coursesDTO.setIsIndoorOrOutdoorActivity(course.getIsIndoorOrOutdoorActivity());
        coursesDTO.setNoOfAvailablePlaces(course.getNoOfAvailablePlaces());
        return coursesDTO;
    }

    private Course mapToEntity(final CoursesDTO coursesDTO, final Course course) {
        course.setLocalisation(coursesDTO.getLocation());
        course.setDate(coursesDTO.getDate());
        course.setIsIndoorOrOutdoorActivity(coursesDTO.getIsIndoorOrOutdoorActivity());
        course.setNoOfAvailablePlaces(coursesDTO.getNoOfAvailablePlaces());
        return course;
    }

    public User registerCourse(User user, Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        Set<Course> courses = new HashSet<>();
        courses.add(course);
        user.setCourseXrefUser(courses);
        return userRepository.save(user);
    }
}
