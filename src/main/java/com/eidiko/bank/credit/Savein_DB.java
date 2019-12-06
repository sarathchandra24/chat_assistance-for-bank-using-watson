package com.eidiko.bank.credit;

import com.eidiko.bank.Credentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Savein_DB {
	Connection con = null;
	String CDF="" ;
	@SuppressWarnings("unused")
	public Savein_DB(String cardNumber, String cvv, String date, String cust_id, String mobile_number, String person,String credit_card_family) {
		// TODO Auto-generated
		try {
			int i = credit_card_family.indexOf(":");
		//	System.out.println(i);
			for(int j=0;j<i;j++) {
				CDF +=credit_card_family.charAt(j);
			}
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://"+Credentials.URL+":3306/" + Credentials.database,Credentials.user, Credentials.password);
			String query = "insert into "+Credentials.CreditCardTable+" values('" + cardNumber +
																"','" + cvv +
																"','" + date +
																"','"+CDF+
																"','" + person +
																"','" + cust_id+
																"','" + mobile_number + "');";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
