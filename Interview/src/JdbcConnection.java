//STEP 1: Import JDBC packages
//STEP 2: Load and register the JDBC driver

import java.sql.*;

public class JdbcConnection {

	public static void main(String[] args) {
		
		String connectionUrl = "jdbc:sqlserver://111.111.111.111;" + 
                "database=myDatabase;" + 
                "user=abcd@xyz.com;" + 
                "password=xyz";
		
		// Declare the JDBC objects.  
        Connection connection = null;  
        Statement statement = null;   
        ResultSet resultSet = null;  


        try {
        	 //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           
           //STEP 3: Open a connection to the Database
            connection = DriverManager.getConnection(connectionUrl);  
            System.out.println("Connected.");
            
         // Create and execute a SELECT SQL statement.  
            String selectSql = "SELECT TOP 5 deviceimeino from proteusdata order by id desc";
            
            //STEP 4: Create a statement object to perform a query
            statement = connection.createStatement();
            
            //STEP 5: Execute the statement object and return a query resultset
            resultSet = statement.executeQuery(selectSql);  

            //STEP 6: Process the resultset
            while (resultSet.next())   
            {  
                System.out.println(resultSet.getString(1));  
            }  
        }  
        catch (Exception e) {  
            e.printStackTrace();  
        }  
        finally {
        
        //STEP 7: Close the resultset, statement and connection objects.
        	  if (resultSet != null) try { resultSet.close(); } catch(Exception e) {}  
            if (statement != null) try { statement.close(); } catch(Exception e) {} 
            if (connection != null) try { connection.close(); } catch(Exception e) {}  
        }  
		
	}

}
