package controller;

import java.sql.*;

import javax.swing.JOptionPane;

import model.Customer;
import model.Restaurant;

public class SignUpController {
	
	private DataBaseController db = DataBaseController.getInstance();

	public SignUpController()
	{
		
	}
	
	
	public int SignUpCustomer(Customer customer)
	{
		if(customer.getCustomerUserName().equals("") || customer.getCustomerSurrname().equals("") || customer.getCustomerName().equals("") || customer.getCustomerPassword().equals("") || customer.getCustomerAdress().equals("") || customer.getCustomerContact().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Fields with * are mandatory!", "", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		try
		{
		db.commitStatement(String.format("INSERT INTO Customer (CustomerUserName, CustomerPassword, CustomerName, CustomerSurrname, CustomerAdress, CustomerContact) VALUES ('%s','%s','%s','%s','%s','%s')",
				customer.getCustomerUserName(),customer.getCustomerPassword(),customer.getCustomerName(),customer.getCustomerSurrname(),customer.getCustomerAdress(),customer.getCustomerContact()
                )); 
		
		}
		catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(null, "In fields regarded to working hours you must input numbers, not letters!", "", JOptionPane.ERROR_MESSAGE);
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		finally
		{
			return 1;
		}
	}
	
	public int SignUpRestaurant(Restaurant restaurant)
	{
		if(restaurant.getRestaurantUserName().equals("") || restaurant.getRestaurantPassword().equals("") || restaurant.getRestaurantName().equals("") || restaurant.getRestaurantAdress().equals("") || restaurant.getRestaurantContact().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Fields with * are mandatory!", "", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		try
		{
		db.commitStatement(String.format("INSERT INTO Restaurant (RestaurantUserName, RestaurantPassword, RestaurantName, RestaurantAdress, RestaurantContact, RestaurantWorksFrom, RestaurantWorksTo) VALUES ('%s','%s','%s','%s','%s','%s',%s)",
					restaurant.getRestaurantUserName(),restaurant.getRestaurantPassword(),restaurant.getRestaurantName(),restaurant.getRestaurantAdress(), restaurant.getRestaurantContact(), restaurant.getRestaurantWorksFrom(),restaurant.getRestaurantWorksTo()
                )); 
		return 1;
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return 0;
		}
	}
}

