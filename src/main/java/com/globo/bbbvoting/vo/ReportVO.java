package com.globo.bbbvoting.vo;

import java.util.Date;

public class ReportVO {

	public ReportVO(){
	}

	public ReportVO(Date date, String hour, Long optionOne, Long optionTwo){
		this.date = date;
		this.hour = hour;
		this.optionOne = optionOne;
		this.optionTwo = optionTwo;
	}
	
	private Date date;
	private String hour;
	private Long optionOne;
	private Long optionTwo;
	
	public Date getVoteDate() {
		return date;
	}
	public void setVoteDate(Date voteDate) {
		this.date = voteDate;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public Long getOptionOne() {
		return optionOne;
	}
	public void setOptionOne(Long optionOne) {
		this.optionOne = optionOne;
	}
	public Long getOptionTwo() {
		return optionTwo;
	}
	public void setOptionTwo(Long optionTwo) {
		this.optionTwo = optionTwo;
	}
	public Long getHourlyCount() {
		return optionOne + optionTwo;
	}
}
