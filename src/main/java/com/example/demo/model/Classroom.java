package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "course_code")
    private String courseCode;

    private LocalDate semester;

    @ManyToOne
    @JoinColumn (name = "teacher_id")
    private User teacher;

}
