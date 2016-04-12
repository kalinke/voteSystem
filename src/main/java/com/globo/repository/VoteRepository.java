package com.globo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globo.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer>{

}
