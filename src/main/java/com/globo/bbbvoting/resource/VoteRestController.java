package com.globo.bbbvoting.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globo.bbbvoting.domain.Vote;
import com.globo.bbbvoting.service.VoteService;
import com.globo.bbbvoting.vo.VoteResultsVO;

@RestController
@RequestMapping("/vote")
public class VoteRestController {

	private VoteService voteService;

	@Autowired
	public VoteRestController(VoteService voteService) {
		this.voteService = voteService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String teste() {
		return "OK";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<VoteResultsVO> vote(@RequestBody Vote vote) {
		getVoteService().vote(vote);
		VoteResultsVO partialResults = voteService.getPartialResults();
		return new ResponseEntity<VoteResultsVO>(partialResults, HttpStatus.OK);
	}

	public VoteService getVoteService() {
		return voteService;
	}

	public void setVoteService(VoteService voteService) {
		this.voteService = voteService;
	}
}
