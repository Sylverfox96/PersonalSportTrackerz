package com.developer.pst.personal_sport_trackerz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class CoursesDTO {

    private Long id;

    @Size(max = 255)
    private String location;

    private LocalDate date;

    @JsonProperty("isIndoorOrOutdoorActivity")
    private Boolean isIndoorOrOutdoorActivity;

    private Integer noOfAvailablePlaces;

}
