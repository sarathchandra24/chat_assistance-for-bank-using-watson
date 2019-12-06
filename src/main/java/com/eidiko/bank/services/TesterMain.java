package com.eidiko.bank.services;

import com.eidiko.bank.credit.CardNumberGeneration;
import com.eidiko.bank.credit.Deletein_DB;
import com.eidiko.bank.credit.ExpiryDateGeneration;
import com.eidiko.bank.credit.GenerateCVV;
import com.eidiko.bank.credit.Savein_DB;

public class TesterMain {
	public static void main(String ar[]) {
		String Cust_id = "";
		String credit_card_family="Co-branded cards:(Co-branded cards)";
		String mobile_number = "";
		String person = "";
		
		VerifyDetails v = new VerifyDetails(Cust_id, mobile_number );
		boolean verification = v.verify();
	//	System.out.print(verification);
		if(verification) {
			CardNumberGeneration cng = new CardNumberGeneration();
			String CardNumber = cng.cardNumber();
			System.out.println(CardNumber+"  : card number");
			
			GenerateCVV gcvv = new GenerateCVV();
			String cvv = gcvv.generateCVV();
			
			System.out.println("CVV is "+ cvv);
			
			String Date = ExpiryDateGeneration.date();
			System.out.println("Date is "+Date);
			
			Savein_DB s = new Savein_DB(CardNumber,cvv,Date,Cust_id,mobile_number,person,credit_card_family);
			Deletein_DB d = new Deletein_DB(CardNumber);
		}
	}
}
