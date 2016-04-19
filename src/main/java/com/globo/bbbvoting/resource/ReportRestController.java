package com.globo.bbbvoting.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globo.bbbvoting.service.ReportService;
import com.globo.bbbvoting.vo.ReportVO;

@RestController
@RequestMapping("/report")
public class ReportRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReportRestController.class);
	
	private ReportService reportService;

	@Autowired
	public ReportRestController(ReportService service) {
		this.reportService = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ReportVO>> getReport() {
		try{
			List<ReportVO> report = reportService.getReport();
			return new ResponseEntity<List<ReportVO>>(report, HttpStatus.OK);
		}catch(Exception e){
			LOGGER.error("Not recognized exception occurred " + e.getMessage());
			LOGGER.debug("Error: ", e);
			e.printStackTrace();
			return new ResponseEntity<List<ReportVO>>(HttpStatus.NO_CONTENT);
		}
	}
}
