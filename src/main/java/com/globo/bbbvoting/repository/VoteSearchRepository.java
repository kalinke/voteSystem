package com.globo.bbbvoting.repository;

import java.util.List;

import com.globo.bbbvoting.vo.VoteResultsHourlyVO;
import com.globo.bbbvoting.vo.VoteResultsVO;

public interface VoteSearchRepository{
	
	VoteResultsVO countResults();

	List<VoteResultsHourlyVO> countResultsHourly();

}