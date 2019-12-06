package com.eidiko.bank.controller;

import com.eidiko.bank.credit.SaveInLog;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eidiko.bank.models.CreditCardRequestINFO;
import com.eidiko.bank.models.CreditCardResponseINFO;
import com.eidiko.bank.services.CreditCardCreationService;

import java.io.IOException;

@RestController
public class CreateCreditCardController {

	@RequestMapping("/api/createcreditcard")
	public CreditCardResponseINFO createCreditCard(@RequestBody CreditCardRequestINFO ccreq) throws IOException {
		String cust_id =String.valueOf(ccreq.getCust_id()),
				mobile_number=String.valueOf(ccreq.getMobile_number()),
				person_name=String.valueOf(ccreq.getPerson()),
				credit_card_family=String.valueOf(ccreq.getCredit_card_family());
		
		/*System.out.println("customer id as number"+(ccreq.getCust_id()));
		System.out.println("mobile number as number"+ccreq.getMobile_number());
		
		
		System.out.println("Customer id that we have got"+cust_id);
		System.out.println("mobile_number we have got"+mobile_number);
		System.out.println("Person name that wemhave got"+person_name);
		System.out.println("Credit card family that we have got"+credit_card_family);

		 */
		CreditCardCreationService c = new CreditCardCreationService
				(cust_id,mobile_number,person_name,credit_card_family);
		// System.out.println(ccreq.getPerson()); ------  got the person value
		String cardnum=c.returnCardNumber();
		String cvv = c.returnCvv();
		String Expiry = c.returndate();
		CreditCardResponseINFO ccres = new CreditCardResponseINFO();
		ccres.setCardnumber(cardnum);
		ccres.setCvv(cvv);
		ccres.setExpiry(Expiry);
		//System.out.println(ccres.getCardnumber()+": card number   ");
		//System.out.println(ccres.getCvv()+":   CVV");
		//System.out.println(ccres.getExpiry()+":   Expiry date");
		SaveInLog s = new SaveInLog(cust_id,mobile_number,person_name,credit_card_family,cardnum,cvv,Expiry);

		return ccres;
		
	}

}
