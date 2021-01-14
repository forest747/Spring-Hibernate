package com.dennis.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("com.dennis.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	// define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneSerivce() {
		return new SadFortuneService();
	}
	
	// define bean for our swim coach And inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneSerivce());
	}
	
	
	
	
	
	
}
