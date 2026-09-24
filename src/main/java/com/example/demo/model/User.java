package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(nullable = false)
    private String fullName;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Classroom> ownedRepositories;

    @JsonIgnore
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Repository> taughtRepositories;

    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Commit> authoredCommits;

    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<PullRequest> authoredPullRequests;

    @JsonIgnore
    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL)
    private List<PullRequest> reviewedPullRequests;

}
