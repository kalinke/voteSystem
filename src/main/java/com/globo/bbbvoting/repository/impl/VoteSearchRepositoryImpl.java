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
import com.globo.bbbvoting.vo.VoteResultsHourlyVO;
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
	public VoteResultsVO countResults() {
		String query = "SELECT COUNT(CASE WHEN USER_OPTION = 1 THEN 1 END) AS OPTION_ONE, COUNT(CASE WHEN USER_OPTION = 2 THEN 1 END) AS OPTION_TWO FROM vote;";
		VoteResultsVO result = (VoteResultsVO) jdbcTemplate.queryForObject(query, new VoteSearchRowMapper());
        return result;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<VoteResultsHourlyVO> countResultsHourly() {
		String query = "SELECT VOTE_DATE AS DATE, HOUR(VOTE_DATE) AS HOUR, COUNT(*) AS VOTES FROM vote GROUP BY DAY(VOTE_DATE), HOUR(VOTE_DATE);";
		
		List<VoteResultsHourlyVO> results = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		
		for (Map<String, Object> row : rows) {
			VoteResultsHourlyVO voteSearchHourlyDTO = new VoteResultsHourlyVO();
			voteSearchHourlyDTO.setVoteDate((Date) row.get("date"));
			voteSearchHourlyDTO.setHour((Integer) row.get("hour"));
			voteSearchHourlyDTO.setVotes((Long) row.get("votes"));
			results.add(voteSearchHourlyDTO);
		}
		
		return results;
	}
}