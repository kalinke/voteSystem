package com.globo.bbbvoting.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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

import com.globo.bbbvoting.domain.Vote;
import com.globo.bbbvoting.repository.VoteRepository;
import com.globo.bbbvoting.repository.VoteSearchRepository;
import com.globo.bbbvoting.service.imp.VoteServiceImp;
import com.globo.bbbvoting.vo.VoteResultsVO;

@RunWith(MockitoJUnitRunner.class)
public class VoteRestControllerTest {

	@Mock
	private VoteRepository voteRepository;
	@Mock	
	private VoteSearchRepository voteSearchRepository;

	private VoteServiceImp voteServiceImp;

	@Before
	public void initializate() {
		this.voteServiceImp = new VoteServiceImp(voteRepository, voteSearchRepository);
	}

	@Test
	public void shouldVote() {
		//Given
		Vote vote = new Vote(null, 1, null);
		Date voteDate = new Date();
		Vote dbVote = new Vote(1, 1, voteDate);

		//When
		when(voteRepository.save(vote)).thenReturn(dbVote);
		
		Vote response = voteServiceImp.vote(vote);
        
		//Then
		assertNotNull(response);
		assertEquals(1, response.getId().intValue());
		assertEquals(1, response.getOption().intValue());
		verify(voteRepository, times(1)).save(vote);
		verifyNoMoreInteractions(voteRepository, voteSearchRepository);
	}

	@Test
	public void shouldGetPartialResults() {
		//Given
		VoteResultsVO result = new VoteResultsVO(10,10);
		
		//When
		when(voteSearchRepository.countResults()).thenReturn(result);
		
		VoteResultsVO response = voteServiceImp.getPartialResults();
		
		//Then
		assertNotNull(response);
		assertEquals(new Float(50), Float.valueOf(response.getOptionOnePercentage()));
		assertEquals(new Float(50), Float.valueOf(response.getOptionTwoPercentage()));
		verify(voteSearchRepository, times(1)).countResults();
		verifyNoMoreInteractions(voteRepository, voteSearchRepository);
	}
	
}