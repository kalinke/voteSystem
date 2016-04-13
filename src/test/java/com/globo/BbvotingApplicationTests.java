package com.globo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.globo.bbbvoting.BBBVotingApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BBBVotingApplication.class)
@WebAppConfiguration
public class BbvotingApplicationTests {

	@Test
	public void contextLoads() {
	}
	
}
