package com.globo.bbbvoting.repository;

import java.util.List;

import com.globo.bbbvoting.vo.ReportVO;
import com.globo.bbbvoting.vo.VoteResultsVO;

public interface VoteSearchRepository{
	
	VoteResultsVO getPartialResults();

	List<ReportVO> getReport();

}