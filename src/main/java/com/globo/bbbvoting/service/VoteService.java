package com.globo.bbbvoting.service;

import java.util.List;

import com.globo.bbbvoting.domain.Vote;
import com.globo.bbbvoting.vo.VoteResultsHourlyVO;
import com.globo.bbbvoting.vo.VoteResultsVO;

public interface VoteService {

	Vote vote(Vote vote);
	
	VoteResultsVO getPartialResults();
	
	List<VoteResultsHourlyVO> getResults();
}
