package com.eidiko.bank.credit;

import java.util.Random;

public class GenerateCVV {
	public String generateCVV() {

		Random rand = new Random();
		int low = 100;
		int high = 1000;
		int cvv = rand.nextInt(high-low) + low;
	
	return String.valueOf(cvv);
	}
}
