package com.eidiko.bank.credit;

import com.eidiko.bank.Credentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CardNumberVerification {
	String user, password, database, cardNumber, tablename;
	// creditString[]=null;
	Connection con = null;
	Statement stmt;
	int i = 0;

	public CardNumberVerification() {
		user = Credentials.user;//"u288413145_root";
		password = Credentials.password;
		database = Credentials.database;
	}

	public boolean cardVerification(String card_num) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://"+Credentials.URL+":3306/" + database, user, password);
			stmt = con.createStatement();
			// System.out.println("Came here in Card Number Verification after stmt");
			ResultSet rs = stmt.executeQuery("select * from "+Credentials.CreditCardTable);
			// System.out.println("Came here after ResultSet");
			while (rs.next()) {
				//System.out.println(rs.getString(1));
				// System.out.println(card_num);
				if (rs.getString(1).equals(card_num)) {
					//System.out.println("Came here if of while");
					i++;
				return false;
				}
			}
			// System.out.println(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getStackTrace();
		}

		return true;

	}
}
