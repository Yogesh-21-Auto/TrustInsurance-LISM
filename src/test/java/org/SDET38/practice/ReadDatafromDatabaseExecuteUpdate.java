package org.SDET38.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDatafromDatabaseExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		// create object
		Driver driver = new Driver();
				
		//register or load the JDBC
		DriverManager.registerDriver(driver);
				
		Connection conn = null;// globally created
				
		//create connectivity - provide database name
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/TYSS", "root", "root");
				
		//create statement
		Statement state = conn.createStatement();
		
		//insert rows/values into table
		String insertquery = "insert into empdetails (id,name,phonenumber,address) values(1,'Yogi',019336893,'Nagarbhavi'), (2,'Rashmi',018336893,'chandralayout');";
		
		//update query
		int updatedresult = state.executeUpdate(insertquery);
		
		System.out.println(updatedresult);
		
		//validation
		if(updatedresult==1)
		{
			System.out.println("Data to added");
		}
		else {
			System.out.println("Data not added");
		}
		
		//close connection
		conn.close();
	}

}
