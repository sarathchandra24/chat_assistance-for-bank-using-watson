package com.eidiko.bank.models;

public class CreditCardRequestINFO {
	String person,credit_card_family;
	long mobile_number,cust_id;
	public CreditCardRequestINFO(){
		
	}
	public String getCredit_card_family() {
		return credit_card_family;
	}
	public void setCredit_card_family(String credit_card_family) {
		this.credit_card_family = credit_card_family;
	}
	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public long getCust_id() {
		return cust_id;
	}

	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}
}
