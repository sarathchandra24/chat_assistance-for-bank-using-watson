package com.eidiko.bank.credit;

import java.util.Calendar;

public class ExpiryDateGeneration {
	public  static String date() {
		String date="";

		/*LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        date = current.format(formatter);
        System.out.println("Current Date and Time is: " + date);
        */
		
	    Calendar now = Calendar.getInstance();
	    now.add(Calendar.YEAR,5);
	    date = (now.get(Calendar.YEAR)
	    		+ "-"
	    		+ (now.get(Calendar.MONTH)+1))
                + "-"
                + now.get(Calendar.DATE);
	    
		return date;
	}
}
