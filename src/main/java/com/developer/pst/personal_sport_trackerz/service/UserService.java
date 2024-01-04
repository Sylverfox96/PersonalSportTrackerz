package com.developer.pst.personal_sport_trackerz.service;

import com.developer.pst.personal_sport_trackerz.dto.UsersDTO;
import com.developer.pst.personal_sport_trackerz.entity.User;
import com.developer.pst.personal_sport_trackerz.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UsersDTO> findAll() {
        final List<User> userses = userRepository.findAll(Sort.by("id"));
        return userses.stream()
                .map(users -> mapToDTO(users, new UsersDTO()))
                .toList();
    }

    public Long create(final UsersDTO usersDTO) {
        final User user = new User();
        mapToEntity(usersDTO, user);
        return userRepository.save(user).getId();
    }


    private UsersDTO mapToDTO(final User user, final UsersDTO usersDTO) {
        usersDTO.setId(user.getId());
        usersDTO.setFirstName(user.getFirstName());
        usersDTO.setLastName(user.getLastName());
        usersDTO.setEmail(user.getEmail());
        usersDTO.setAge(user.getAge());
        usersDTO.setRole(user.getRole().name());
        usersDTO.setCreatedAt(user.getCreatedAt());
        usersDTO.setUpdatedAt(user.getUpdatedAt());
        return usersDTO;
    }

    private User mapToEntity(final UsersDTO usersDTO, final User user) {
        user.setFirstName(usersDTO.getFirstName());
        user.setLastName(usersDTO.getLastName());
        user.setEmail(usersDTO.getEmail());
        user.setAge(usersDTO.getAge());
        user.setRole(User.Role.valueOf(usersDTO.getRole()));
        user.setCreatedAt(usersDTO.getCreatedAt());
        user.setUpdatedAt(usersDTO.getUpdatedAt());
        return user;
    }

    public User unregisterCourse(User user, Long courseId) {
        return null;
    }

    public User getCourseByUserId(Long id) {
        User userCourses = userRepository.findById(id).orElseThrow();
        return userCourses;
    }
}
