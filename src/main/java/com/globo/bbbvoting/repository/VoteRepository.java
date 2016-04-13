package com.globo.bbbvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globo.bbbvoting.domain.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer>{
	
	Long countByOption(Integer option);
}