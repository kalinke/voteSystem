package com.globo.bbbvoting.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globo.bbbvoting.repository.VoteSearchRepository;
import com.globo.bbbvoting.service.ReportService;
import com.globo.bbbvoting.vo.ReportVO;

@Service
@Transactional
public class ReportServiceImp implements ReportService{
	
	private VoteSearchRepository voteSearchRepository;

	@Autowired
	public ReportServiceImp(VoteSearchRepository voteSearchRepository){
		this.voteSearchRepository = voteSearchRepository;
	}
	
	@Override
	public List<ReportVO> getReport() {
		List<ReportVO> report = voteSearchRepository.getReport();
		return report;
	}
}
