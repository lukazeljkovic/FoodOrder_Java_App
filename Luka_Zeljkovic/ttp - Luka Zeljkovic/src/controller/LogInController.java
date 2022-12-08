package controller;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.sql.*;

import model.Customer;
import model.Restaurant;

public class LogInController {

	private ArrayList<Customer> customerList = new ArrayList<>();
	
	private ArrayList<Restaurant> restaurantList = new ArrayList<>();
	
	private DataBaseController db = DataBaseController.getInstance();
	
	private RestaurantController restaurantController = new RestaurantController();
	
	private CustomerController customerController = new CustomerController();
	
	public static int currUser;
	
	public LogInController ()
	{
		populateLists();
	}
	
	// filling the list from which the authentication  is done
	private void populateLists() {  
     
            restaurantList = restaurantController.getRestaurantList();
            customerList = customerController.getCustomerList();
   }  
	
	
	
	public int authenticate (String UserName, String Password)
	{
		populateLists();
		for (Customer customer : customerList) {
			if(customer.getCustomerUserName().equals(UserName) && customer.getCustomerPassword().equals(Password))
			{
				currUser = customer.getCustomerID();
				
				return 1;
			}
		}
		
		for(Restaurant restaurant : restaurantList) {
			if(restaurant.getRestaurantUserName().equals(UserName) && restaurant.getRestaurantPassword().equals(Password))
			{
				currUser = restaurant.getRestaurantID();
				return 2;
			}
		}
		
		return 0;
	
	}
	
	
}
