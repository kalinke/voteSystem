package com.globo.bbbvoting.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.globo.bbbvoting.vo.VoteResultsVO;

@SuppressWarnings("rawtypes")
public class VoteSearchRowMapper implements RowMapper {
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		VoteResultsVO voteSearchDTO = new VoteResultsVO();
		voteSearchDTO.setOptionOne(rs.getInt("OPTION_ONE"));
		voteSearchDTO.setOptionTwo(rs.getInt("OPTION_TWO"));
		return voteSearchDTO;
	}
}
