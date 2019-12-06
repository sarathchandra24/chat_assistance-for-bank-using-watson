package com.eidiko.bank.services;

import com.eidiko.bank.credit.CardNumberGeneration;
import com.eidiko.bank.credit.ExpiryDateGeneration;
import com.eidiko.bank.credit.GenerateCVV;
import com.eidiko.bank.credit.Savein_DB;

public class CreditCardCreationService {

	String CardNumber="",cvv="",Date="";
	public CreditCardCreationService(String Cust_id, String mobile_number, String person,String credit_card_family) {
		// System.out.println("Entered in to constructor");
		//System.out.println("person value:"+person);
		VerifyDetails V = new VerifyDetails(Cust_id,mobile_number);
		boolean verification = V.verify();
		if(verification) {
		//	System.out.println("Entered in to verification");
			CardNumberGeneration cng = new CardNumberGeneration();
			CardNumber = cng.cardNumber(); //this has the value of the new card number
			
			GenerateCVV gcvv = new GenerateCVV();
			 cvv = gcvv.generateCVV();
			
			Date = ExpiryDateGeneration.date();
			
			Savein_DB s = new Savein_DB(CardNumber,cvv,Date,Cust_id,mobile_number,person,credit_card_family);
		}
		
		
	}
	public String returnCardNumber() {
		return CardNumber;
	}
	public String returnCvv() {
		return cvv;
	}
	public String returndate() {
		return Date;
	}

}
