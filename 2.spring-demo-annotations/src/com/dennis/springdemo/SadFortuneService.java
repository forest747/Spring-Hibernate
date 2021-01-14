package com.dennis.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {

		return "To day is a sad day";
	}

}
