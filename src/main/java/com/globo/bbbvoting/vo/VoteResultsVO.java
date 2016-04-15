package com.globo.bbbvoting.vo;

public class VoteResultsVO {

	public VoteResultsVO(){
	}

	public VoteResultsVO(Integer optionOne, Integer optionTwo){
		this.optionOne = optionOne;
		this.optionTwo = optionTwo;
	}
	
	private Integer optionOne;
	private Integer optionTwo;
	
	public Integer getOptionOne() {
		return optionOne;
	}
	public void setOptionOne(Integer optionOne) {
		this.optionOne = optionOne;
	}
	public Integer getOptionTwo() {
		return optionTwo;
	}
	public void setOptionTwo(Integer optionTwo) {
		this.optionTwo = optionTwo;
	}
	
	public float getOptionOnePercentage() {
		return (optionOne * 100) / (optionOne + optionTwo);
	}
	public float getOptionTwoPercentage() {
		return (optionTwo * 100) / (optionOne + optionTwo);
	}
}
