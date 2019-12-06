package com.eidiko.bank.credit;

import java.util.Random;

public class Random15Generator {
	public String randomNumberGenerator() {
		// TODO Auto-generated constructor stub
		Random rand = new Random();
		String temp="";
		for(int i=0;i<15;i++) {
			int inttemp = rand.nextInt(10);
			 temp+=String.valueOf(inttemp);
		}

		return temp;
	}
}
