package com.eidiko.bank.services;

import com.eidiko.bank.Credentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VerifyDetails {

	String Cust_id, mobile_number;
	int i = 0;

	public VerifyDetails(String cust_id, String mobile_number) {
		// TODO Auto-generated constructor stub

		this.Cust_id = cust_id;
		//System.out.println("local cust id is " +cust_id);
		this.mobile_number = mobile_number;
		//System.out.println(mobile_number);

	}

	public boolean verify() {
		
		//System.out.println("entered the verify methodd");
		// TODO Auto-generated method stub
		ResultSet rs;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://"+Credentials.URL+":3306/"+Credentials.database, Credentials.user,
					Credentials.password);
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("select * from "+Credentials.CustomerDetails+" where customer_id = '" + Cust_id + "'");
			//System.out.println(" customer id value in  the statement:  "+Cust_id);
			while (rs.next()) {
			//	System.out.println(rs.getString(3)+"  customer phone number in database");
			//	System.out.println(mobile_number+"    phone number tht is passed in to");

				if (mobile_number.equals(rs.getString(3))) {
				//	System.out.println(mobile_number+" mobile_number value in if");
					
					i++;
					return true;
				//	System.out.println("came here");	
				}
			}
			//System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
