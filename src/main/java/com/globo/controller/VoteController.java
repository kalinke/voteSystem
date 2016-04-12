package com.globo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vote")
public class VoteController {

	@RequestMapping(method = RequestMethod.GET)
	public String teste(){
		return "OK";
	}
	
	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String voteById(@PathVariable String id){
		return id;
	}
	
}
