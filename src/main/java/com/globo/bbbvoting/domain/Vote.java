package com.globo.bbbvoting.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "VOTE")
public class Vote {

	public Vote() {
	}

	public Vote(Integer id, Integer option, Date voteDate) {
		this.id = id;
		this.option = option;
		this.voteDate = voteDate;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="USER_OPTION")
	private Integer option;

	@Column(name="VOTE_DATE")
	private Date voteDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOption() {
		return option;
	}
	public void setOption(Integer option) {
		this.option = option;
	}
	public Date getVoteDate() {
		return voteDate;
	}
	public void setVoteDate(Date voteDate) {
		this.voteDate = voteDate;
	}
	
}
