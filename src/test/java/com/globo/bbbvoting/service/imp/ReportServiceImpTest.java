package com.globo.bbbvoting.service.imp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.globo.bbbvoting.repository.VoteSearchRepository;
import com.globo.bbbvoting.vo.ReportVO;

@RunWith(MockitoJUnitRunner.class)
public class ReportServiceImpTest {

	@Mock	
	private VoteSearchRepository voteSearchRepository;

	private ReportServiceImp voteServiceImp;

	@Before
	public void initializate() {
		this.voteServiceImp = new ReportServiceImp(voteSearchRepository);
	}

	@Test
	public void shouldGetReport() {
		//Given
		ArrayList<ReportVO> report = new ArrayList<>(Arrays.asList(new ReportVO(new Date(), "hour", 1l, 1l)));
		
		//When
		when(voteSearchRepository.getReport()).thenReturn(report);
		
		List<ReportVO> response = voteServiceImp.getReport();
		
		//Then
		assertNotNull(response);
		assertEquals("hour", response.get(0).getHour());
		verify(voteSearchRepository, times(1)).getReport();
		verifyNoMoreInteractions(voteSearchRepository);
	}
	
}