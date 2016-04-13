package com.globo.bbbvoting.service;

import com.globo.bbbvoting.domain.Vote;
import com.globo.bbbvoting.vo.VoteResultsVO;

public interface VoteService {

	Vote vote(Vote vote);
	
	VoteResultsVO getPartialResults();
}
