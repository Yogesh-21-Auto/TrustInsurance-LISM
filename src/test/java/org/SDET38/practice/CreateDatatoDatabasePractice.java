package org.SDET38.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CreateDatatoDatabasePractice {

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
		  
		  //create table
		String createquery = "create table empdetails(id int(1) not null, name varchar(20) not null, phonenumber int(10), address varchar(50) not null, primary key (id));";
		
		ResultSet create = state.executeQuery(createquery);
		//validation
		System.out.println("table is created");
		
		//close
		conn.close();
	}

}
