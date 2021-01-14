package com.dennis.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Value("${foo.email}")
	private String email;

	@Value("${foo.team}")
	private String team;
	
	@Override
	public String getDailyWorkout() {
		return "Swimm 1000 meters as a warm up!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

}
