package com.globo.bbbvoting.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import com.globo.bbbvoting.repository.rowmapper.VoteSearchRowMapper;
import com.globo.bbbvoting.vo.VoteResultsVO;

@RunWith(MockitoJUnitRunner.class)
public class VoteSearchRepositoryImplTest {

	@Mock
	JdbcTemplate jdbcTemplate;

	private VoteSearchRepositoryImpl voteSearchRepositoryImpl;

	@Before
	public void initializate() {
		this.voteSearchRepositoryImpl = new VoteSearchRepositoryImpl(jdbcTemplate);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldCountResults() {
		//Given
		VoteResultsVO result = new VoteResultsVO(10,10);

		//Whend
		doReturn(result).when(jdbcTemplate).queryForObject(anyString(), any(VoteSearchRowMapper.class)); 
		
		VoteResultsVO response = voteSearchRepositoryImpl.getPartialResults();
        
		//Then
		assertNotNull(response);
		assertEquals(new Float(50), Float.valueOf(response.getOptionOnePercentage()));
		assertEquals(new Float(50), Float.valueOf(response.getOptionTwoPercentage()));
		verify(jdbcTemplate, times(1)).queryForObject(anyString(), any(VoteSearchRowMapper.class));
		verifyNoMoreInteractions(jdbcTemplate);
	}
}