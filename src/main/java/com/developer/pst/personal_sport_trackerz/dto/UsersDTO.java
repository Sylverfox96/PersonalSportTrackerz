package com.developer.pst.personal_sport_trackerz.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class UsersDTO {

    private Long id;

    @NotNull
    @Size(max = 64)
    private String firstName;

    @Size(max = 64)
    private String lastName;

    @NotNull
    @Size(max = 128)
    private String email;

    @NotNull
    private Integer age;

    @NotNull
    @Size(max = 64)
    private String role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
