package com.trustinsurance.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
* Its JDBCutility is a class and it contains specific/reusable actions like toConnect,toCreateStatement,toExecuteQuery,toClose utiliies etc..
*@author acer
*/
public class JDBCUtility implements Iconstants 
{
    /**
     * To connect JDBC
     * @throws SQLException
     */
	public void toConnectDb() throws SQLException
	{
		/**
		 * to create an driver object for JDBC
		 */
		Driver driver = new Driver();
		
		/**
		 * to load JDBC
		 */
		DriverManager.registerDriver(driver);
		
		Connection connection = null;
		/**
		 * to connect JDBC to driver
		 */
		connection = DriverManager.getConnection(Iconstants.localHost, Iconstants.User, Iconstants.pass);
		
		/**
		 * Create statements
		 */
		Statement state = connection.createStatement();
		
		String tablename = "select * from empdetails;";
		ResultSet fetchRes = state.executeQuery(tablename);
		
		String excData = "Yogi";
		
		boolean flag = false;
		while(fetchRes.next())
		{
			String actData= fetchRes.getString(1);
			if(actData.equalsIgnoreCase(excData))
			{
				System.out.println(actData);
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
		connection.close();
		System.out.println("closed connection");
			}
			
	public class DataBaseUtility {
		
		Driver driver;
		Connection connection;
		ResultSet result;
	    
		/**
		 * This method will perform the mysql database connection
		 * @throws SQLException 
		 */
		public void connectDB() throws SQLException {
			try {
				driver=new Driver();
				DriverManager.registerDriver(driver);
				connection=DriverManager.getConnection(Iconstants.localHost,Iconstants.User,Iconstants.pass);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/**
		 * This method will close the mysql database
		 * @throws SQLException
		 */
		public void closeDB() throws SQLException {
			try {
			  connection.close();
			}catch (Exception e) {
			}


		}
		/**
		 * This method will execute the querry
		 * @param query
		 * @return
		 * @throws Throwable
		 */
		public ResultSet execyteQuery(String query) throws Throwable {	
				result = connection.createStatement().executeQuery(query);
				return result;		
		}
		
		/**
		 * This method will execute the querry
		 * @param query
		 * @return
		 * @throws Throwable
		 */
		public int execyteUpdate(String query) throws Throwable {
			
				int result = connection.createStatement().executeUpdate(query);
		
			return result;

		}
		/**
		 * This method will execute querry based on querry and it will verify the data. 
		 * @param querry
		 * @param columnName
		 * @param expectedData
		 * @return
		 * @throws Throwable
		 */
		public boolean executeQuerryAndVerify(String querry,int cloumnIndex,String expectedData) throws Throwable {
			boolean flag=false;
			result=connection.createStatement().executeQuery(querry);
			while(result.next()) {
				if(result.getString(cloumnIndex).equals(expectedData)) {
					flag=true;
					break;
				}
			}
			if(flag) {
				System.out.println(expectedData+"==>Data is verified in the data base table");
				return flag;
			}else {
				System.out.println(expectedData+"==>data is not verified in the database");
				return flag;
			}
	         
		}


	}

		}
