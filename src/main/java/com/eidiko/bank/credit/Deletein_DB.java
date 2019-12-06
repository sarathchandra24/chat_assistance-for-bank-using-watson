package com.eidiko.bank.credit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Deletein_DB {
	Connection con = null;
	
	public Deletein_DB(String cardNumber){
		String user = "root", password = "T0nwhy@$$@", database = "eidiko_bank_project", tablename = "creditcard";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, user, password);
			String query =  "DELETE * FROM creditcard where cardNumber=`"+cardNumber+"`";
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
