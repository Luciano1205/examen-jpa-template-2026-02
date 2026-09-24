package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


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

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @JsonIgnore
    @OneToMany (mappedBy = "repository")
    private List<PullRequest> pullRequests;

    @JsonIgnore
    @OneToMany (mappedBy = "repository")
    private List<Commit> commits;

    @ManyToOne
    @JoinColumn(name = "parent_repo_id")
    private Repository parentRepo;

    @JsonIgnore
    @OneToMany (mappedBy = "parentRepo")
    private List<Repository> parentRepos;
}
