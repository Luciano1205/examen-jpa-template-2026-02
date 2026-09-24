package com.example.demo.repository;

import com.example.demo.model.PullRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPullRequestRepository extends JpaRepository<PullRequest, Long> {

    List<PullRequest> findByRepository_Assignment_Classroom_NameOrderByStatusDesc(String pullRequests);

}
