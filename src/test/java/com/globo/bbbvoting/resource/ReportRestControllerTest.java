package com.globo.bbbvoting.resource;

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
import org.springframework.http.ResponseEntity;

import com.globo.bbbvoting.service.ReportService;
import com.globo.bbbvoting.vo.ReportVO;

@RunWith(MockitoJUnitRunner.class)
public class ReportRestControllerTest {

	@Mock
	private ReportService reportService;

	private ReportRestController reportRestController;

	@Before
	public void initializate() {
		this.reportRestController = new ReportRestController(reportService);
	}

	@Test
	public void shouldGetReport() {
		//Given
		ArrayList<ReportVO> report = new ArrayList<>(Arrays.asList(new ReportVO(new Date(), "hour", 1l, 1l)));

		when(reportService.getReport()).thenReturn(report);
		
		ResponseEntity<List<ReportVO>> response = reportRestController.getReport();
        
		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals("hour", response.getBody().get(0).getHour());
		verify(reportService, times(1)).getReport();
		verifyNoMoreInteractions(reportService);
	}
}