package com.globo.bbbvoting.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.globo.bbbvoting.repository.VoteSearchRepository;
import com.globo.bbbvoting.repository.rowmapper.VoteSearchRowMapper;
import com.globo.bbbvoting.vo.ReportVO;
import com.globo.bbbvoting.vo.VoteResultsVO;

@Repository
public class VoteSearchRepositoryImpl implements VoteSearchRepository{

    JdbcTemplate jdbcTemplate;
	  
	@Autowired
	VoteSearchRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public VoteResultsVO getPartialResults() {
		String query = "SELECT COUNT(CASE WHEN USER_OPTION = 1 THEN 1 END) AS OPTION_ONE, "
				+ "COUNT(CASE WHEN USER_OPTION = 2 THEN 1 END) AS OPTION_TWO FROM vote;";
		VoteResultsVO result = (VoteResultsVO) jdbcTemplate.queryForObject(query, new VoteSearchRowMapper());
        return result;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ReportVO> getReport() {
		String query = "SELECT DATE(VOTE_DATE) AS DATE, CONCAT(HOUR(VOTE_DATE), ':00')  AS HOUR, COUNT(CASE WHEN USER_OPTION = 1 THEN 1 END) "
				+ "AS OPTION_ONE, COUNT(CASE WHEN USER_OPTION = 2 THEN 1 END) AS OPTION_TWO FROM vote GROUP BY DAY(VOTE_DATE), HOUR(VOTE_DATE);";
		
		List<ReportVO> results = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		
		for (Map<String, Object> row : rows) {
			ReportVO report = new ReportVO();
			report.setVoteDate((Date) row.get("date"));	
			report.setHour((String) row.get("hour"));
			report.setOptionOne((Long) row.get("option_one"));
			report.setOptionTwo((Long) row.get("option_two"));
			results.add(report);
		}
		
		return results;
	}
}