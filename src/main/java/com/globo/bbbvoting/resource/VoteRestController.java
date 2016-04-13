package com.globo.bbbvoting.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globo.bbbvoting.domain.Vote;
import com.globo.bbbvoting.service.VoteService;
import com.globo.bbbvoting.service.exception.InvalidVoteException;
import com.globo.bbbvoting.vo.VoteResultsVO;

@RestController
@RequestMapping("/vote")
public class VoteRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(VoteRestController.class);
	
	private VoteService voteService;

	@Autowired
	public VoteRestController(VoteService voteService) {
		this.voteService = voteService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<VoteResultsVO> vote(@RequestBody Vote vote) {
		try{
			assertValidVote(vote);
			getVoteService().vote(vote);
			VoteResultsVO partialResults = voteService.getPartialResults();
			return new ResponseEntity<VoteResultsVO>(partialResults, HttpStatus.OK);
		}catch(InvalidVoteException i){
			LOGGER.error("Invalid vote option sent to server");
			return new ResponseEntity<VoteResultsVO>(HttpStatus.UNPROCESSABLE_ENTITY);
		}catch(Exception e){
			LOGGER.error("Not recognized exception occurred");
			LOGGER.debug("Error: ", e);
			return new ResponseEntity<VoteResultsVO>(HttpStatus.BAD_REQUEST);
		}
	}

	public VoteService getVoteService() {
		return voteService;
	}

	public void setVoteService(VoteService voteService) {
		this.voteService = voteService;
	}
	
	private void assertValidVote(Vote vote) throws InvalidVoteException{
		Integer option = vote.getOption();
		if((option == null) || (option != 1 && option != 2)){
			throw new InvalidVoteException(option);
		}
	}
}
