package com.globo.bbbvoting.service.imp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.globo.bbbvoting.domain.Vote;
import com.globo.bbbvoting.resource.VoteRestController;
import com.globo.bbbvoting.service.VoteService;
import com.globo.bbbvoting.vo.VoteResultsVO;

@RunWith(MockitoJUnitRunner.class)
public class VoteServiceImpTest {

	@Mock
	private VoteService voteService;

	private VoteRestController voteRestController;

	@Before
	public void initializate() {
		this.voteRestController = new VoteRestController(voteService);
	}

	@Test
	public void shouldVote() {
		//Given
		Vote vote = new Vote(null, 1, null);
		VoteResultsVO result = new VoteResultsVO(10,10);

		when(voteService.getPartialResults()).thenReturn(result);
		
		ResponseEntity<VoteResultsVO> response = voteRestController.vote(vote);
        
		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(new Float(50), Float.valueOf(response.getBody().getOptionOnePercentage()));
		assertEquals(new Float(50), Float.valueOf(response.getBody().getOptionTwoPercentage()));
		verify(voteService, times(1)).vote(vote);
		verify(voteService, times(1)).getPartialResults();
		verifyNoMoreInteractions(voteService);
	}
	
	@Test
	public void shouldNotVote() {
		//Given
		Date voteDate = new Date();
		Vote vote = new Vote(null, 10, voteDate);
		VoteResultsVO result = new VoteResultsVO(10,10);
		
		when(voteService.getPartialResults()).thenReturn(result);
		
		ResponseEntity<VoteResultsVO> response = voteRestController.vote(vote);
		
		assertNotNull(response);
		assertNull(response.getBody());
		assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
		verify(voteService, times(0)).vote(vote);
		verify(voteService, times(0)).getPartialResults();
		verifyNoMoreInteractions(voteService);
	}
}