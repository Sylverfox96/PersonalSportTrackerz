package com.developer.pst.personal_sport_trackerz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String localisation;

    @Column
    private LocalDate date;

    @Column
    private Boolean isIndoorOrOutdoorActivity;

    @Column
    private Integer noOfAvailablePlaces;

    @JsonIgnore
    @ManyToMany(mappedBy = "courseXrefUser", fetch = FetchType.EAGER)
    private List<User> userXref = new ArrayList<>();

    public Course(Long id, String localisation, LocalDate date, Boolean isIndoorOrOutdoorActivity, Integer noOfAvailablePlaces) {
        this.id = id;
        this.localisation = localisation;
        this.date = date;
        this.isIndoorOrOutdoorActivity = isIndoorOrOutdoorActivity;
        this.noOfAvailablePlaces = noOfAvailablePlaces;
    }
}
