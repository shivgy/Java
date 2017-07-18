package dbModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewDb {
	private static final String dbURL = "jdbc:sqlserver://111.111.111.111;databaseName = Employee";
	private static final String USER_NAME = "shivgopal";
	private static final String PASSWORD = "@#$%^&*&^%";
	private static final String SQL_QUERY = "SELECT TOP 10* FROM Employee.dbo.data ORDER BY ID DESC";

	public static void main(String[] args){
		

		try{
			Connection myConn = DriverManager.getConnection(dbURL,USER_NAME,PASSWORD);
			Statement myStatement = myConn.createStatement();
			ResultSet myResultSet = myStatement.executeQuery(SQL_QUERY);

			while(myResultSet.next()){
				System.out.println(myResultSet.getString(9) + "" + myResultSet.getString(10));//Print the 9th and 10th Column of the resultset
			}
      
			myConn.close();
      
		}catch(SQLException e){
			System.out.println(e.toString());
		}
	}
}
