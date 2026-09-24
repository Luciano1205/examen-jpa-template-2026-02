package com.example.demo.repository;

import com.example.demo.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> findByClassroom_Teacher_UsernameAndClassroom_Teacher_OwnedRepositories_PullRequests_Reviewer(String usernameTaecher);

}
