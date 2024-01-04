package com.developer.pst.personal_sport_trackerz.controller;

import com.developer.pst.personal_sport_trackerz.dto.UsersDTO;
import com.developer.pst.personal_sport_trackerz.entity.User;
import com.developer.pst.personal_sport_trackerz.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(tags = "User Controller")
@RequestMapping(value = " /v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ApiOperation("Get list of users")
    public ResponseEntity<List<UsersDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }


    @PostMapping
    @ApiOperation("Create a User")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createUsers(@RequestBody @Valid final UsersDTO usersDTO) {
        final Long createdId = userService.create(usersDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/courses/{courseId}/unregister")
    public ResponseEntity<?> registerCourse(@Valid @RequestBody User user, @PathVariable Long courseId) {
        User registerCourse = userService.unregisterCourse(user, courseId);
        return new ResponseEntity<>(registerCourse, HttpStatus.OK);
    }

    @GetMapping("/{userId}/courses")
    @ApiOperation(value = "Get courses by user id")
    public ResponseEntity<User> getCourseByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(this.userService.getCourseByUserId(userId));
    }
}
