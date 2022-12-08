package controller;

import java.sql.*;

import javax.swing.JOptionPane;

public class DataBaseController {
	
	private static DataBaseController instance = null;
	
private Connection connection;
	
	
	
	private DataBaseController()
	{
		setConnection();
	}
	
	public static DataBaseController getInstance()
	{
		if (instance == null)
		{
			instance = new DataBaseController();
		}
		return instance;
	}
	
	public void commitStatement(String query) {  
        try {       
//               Prepare string query as statement to execute       
             PreparedStatement ps = connection.prepareStatement(query);  
               
//               Execute statement for database to update  
             ps.executeUpdate();  
               
        } catch (SQLException e) {  
//               Inform that exception occurred from executing statement  
             JOptionPane.showMessageDialog(null, "An error occured due invalid/conflict in customer data inputted.", "", JOptionPane.ERROR_MESSAGE);  
             e.printStackTrace();  
        }
       
        
	}
	
	public void setConnection()
	{
		 try {  
			 //               Register SQLite JDBC to class path   
			                Class.forName("org.sqlite.JDBC");  
			                  
			 //               Get SQLite connection from given database  
			                connection = DriverManager.getConnection("jdbc:sqlite:FoodOrderDatabase.db");
		 
			                  
			           } catch (ClassNotFoundException | SQLException e) {  
			                // TODO Auto-generated catch block  
			        	   
			                e.printStackTrace();  
			                
			           } 
	
	}
	


	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}


}
