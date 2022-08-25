package org.SDET38.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDatabaseExecuteQuery {

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
				
				//select table - provide table name
				String tablename = "select * from empdetails;";
				
				//fetch value
				String expdata = "Yogi";
				
				//execute query
				 ResultSet fetchresult = state.executeQuery(tablename);
				 
				 //fetch particular data / no limit / no range
				 boolean flag = false;
				 while(fetchresult.next())
				 {
					 //actual result in particular column
					 String actdata = fetchresult.getString(1);
					 
					 //compare exp and act
					 if (actdata.equalsIgnoreCase(expdata))
					 {
						 System.out.println(actdata);
						 flag=true;
						 break;
					 }
	
				 }
				 
				 //validation
if(flag)
{
	System.out.println("data present");
}
else {
	System.out.println("data not present");
}
//close
conn.close();
System.out.println("closed connection");
	}

}
