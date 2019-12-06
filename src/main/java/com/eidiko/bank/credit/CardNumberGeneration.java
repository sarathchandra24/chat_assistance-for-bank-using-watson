package com.eidiko.bank.credit;

public class CardNumberGeneration {
	
	String CreditCardNumber ;
	public void cardNumberGeneration(){
		CreditCardNumber="";
		Random15Generator r15 = new Random15Generator();
		String card15 = r15.randomNumberGenerator();
		CreditCardNumber = "4"+String.valueOf(card15);
		
	}
	
	public String cardNumber() {
		// TODO Auto-generated method stub
		cardNumberGeneration();
		CardNumberVerification c = new CardNumberVerification();
		while(c.cardVerification(CreditCardNumber) == false) {
			cardNumberGeneration();
		}
		return CreditCardNumber;
	}

}
