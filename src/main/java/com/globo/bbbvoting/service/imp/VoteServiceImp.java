package com.globo.bbbvoting.service.imp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globo.bbbvoting.domain.Vote;
import com.globo.bbbvoting.repository.VoteRepository;
import com.globo.bbbvoting.repository.VoteSearchRepository;
import com.globo.bbbvoting.service.VoteService;
import com.globo.bbbvoting.vo.VoteResultsVO;

@Service
@Transactional
public class VoteServiceImp implements VoteService{
	
	private VoteRepository voteRepository;
	private VoteSearchRepository voteSearchRepository;
	
	@Autowired
	private VoteServiceImp(VoteRepository voteRepository, VoteSearchRepository voteSearchRepository){
		this.voteRepository = voteRepository;
		this.voteSearchRepository = voteSearchRepository;
	}

	@Override
	public Vote vote(Vote vote){
		vote.setVoteDate(new Date());
		return (Vote) voteRepository.save(vote);
	}
	
	@Override
	public VoteResultsVO getPartialResults() {
		VoteResultsVO partialResults = voteSearchRepository.countResults();
		return partialResults;
	}
}
