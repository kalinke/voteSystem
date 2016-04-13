package com.globo.bbbvoting.service.exception;

public class InvalidVoteException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidVoteException(Integer option) {
		super("No option found for [ " + option + "]");
	}
}
