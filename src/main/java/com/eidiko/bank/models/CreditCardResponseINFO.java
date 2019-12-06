package com.eidiko.bank.models;

public class CreditCardResponseINFO {
	String cardnumber,expiry,cvv;
	public CreditCardResponseINFO() {
		
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
	//	System.out.println("cardnumber that is passes");
		this.cardnumber = cardnumber;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
}
