package com.globo.bbbvoting.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.globo.bbbvoting.repository.VoteSearchRepository;
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
		
		String query = "SELECT COUNT(CASE WHEN OPTION = 1 THEN 1 END) AS OPTION_ONE, COUNT(CASE WHEN OPTION = 2 THEN 1 END) AS OPTION_TWO FROM vote;";
		
		VoteResultsVO result = (VoteResultsVO) jdbcTemplate.queryForObject(query, new VoteSearchRowMapper());
		
        return result;
	}
	
	@SuppressWarnings("rawtypes")
	private class VoteSearchRowMapper implements RowMapper {
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			VoteResultsVO voteSearchDTO = new VoteResultsVO();
			voteSearchDTO.setOptionOne(rs.getInt("OPTION_ONE"));
			voteSearchDTO.setOptionTwo(rs.getInt("OPTION_TWO"));
			return voteSearchDTO;
		}
	}
}