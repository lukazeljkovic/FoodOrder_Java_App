package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;

public class CustomerController {
	
	private DataBaseController db = DataBaseController.getInstance();
	private ArrayList <Customer> customerList = new ArrayList<>();
	
	public CustomerController()
	{
		populateList();
	}

	private void populateList()
	{
		 try {                 
             PreparedStatement psc = db.getConnection().prepareStatement("SELECT * FROM Customer");  
             ResultSet rsc = psc.executeQuery();  
               
             Customer cust;  
             while(rsc.next()) {  
                 
                    
                  cust = new Customer(rsc.getInt("CustomerID"),  
                                             rsc.getString("CustomerUserName"),  
                                             rsc.getString("CustomerPassword"),  
                                             rsc.getString("CustomerName"),  
                                             rsc.getString("CustomerSurrname"),
                                             rsc.getString("CustomerAdress"),
                                             rsc.getString("CustomerContact"));  
                    
                  customerList.add(cust);  
             }  
             
               
        } catch (SQLException e) {  
             // TODO Auto-generated catch block  
             e.printStackTrace();  
        }  
	}

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}
	
	
}
