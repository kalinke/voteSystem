package com.globo.bbbvoting.vo;

import java.util.Date;

public class VoteResultsHourlyVO {

	public VoteResultsHourlyVO(){
	}
	
	private Date voteDate;
	private Integer hour;
	private Long votes;
	
	public Date getVoteDate() {
		return voteDate;
	}
	public void setVoteDate(Date voteDate) {
		this.voteDate = voteDate;
	}
	public Integer getHour() {
		return hour;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}
	public Long getVotes() {
		return votes;
	}
	public void setVotes(Long votes) {
		this.votes = votes;
	}
}
