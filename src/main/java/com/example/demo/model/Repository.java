package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "repositories")
public class Repository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private boolean is_template;

    private boolean is_private;

    private LocalDate created_at;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;


}
