package com.developer.pst.personal_sport_trackerz.controller;

import com.developer.pst.personal_sport_trackerz.dto.CoursesDTO;
import com.developer.pst.personal_sport_trackerz.entity.User;
import com.developer.pst.personal_sport_trackerz.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(tags = "Course Controller")
@RequestMapping(value = "/v1/courses", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {

    private final CourseService courseService;

    public CourseController(final CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    @ApiOperation("Get all available courses")
    public ResponseEntity<List<CoursesDTO>> getAvailableCourses() {
        return ResponseEntity.ok(courseService.findAll());
    }


    @PutMapping("/{courseId}/register")
    @ApiOperation("Register a course")
    public ResponseEntity<?> registerCourse(@Valid @RequestBody User user, @PathVariable Long courseId) {
        User registerCourse = courseService.registerCourse(user, courseId);
        return new ResponseEntity<>(registerCourse, HttpStatus.OK);
    }


}
