package model;

import java.sql.Date;
import java.time.LocalDate;


public class Order {
	
	private int OrderNumber, CustomerID, OrderStatusID;
	private int OrderTotalAmount;
	private Date OrderDate;
	
	
	public Order()
	{
		
	}
	
	public Order(int OrderNumber, int CustomerID, int OrderStatusID, int OrderTotalAmount, Date OrderDate)
	{
		this.OrderNumber = OrderNumber;
		this.CustomerID = CustomerID;
		this.OrderStatusID = OrderStatusID;
		this.OrderDate = OrderDate;
		this.OrderTotalAmount = OrderTotalAmount;
		
	}
	
	
	
	public int getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		OrderNumber = orderNumber;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public int getOrderStatusID() {
		return OrderStatusID;
	}

	public void setOrderStatusID(int orderStatusID) {
		OrderStatusID = orderStatusID;
	}

	public int getOrderTotalAmount() {
		return OrderTotalAmount;
	}

	public void setOrderTotalAmount(int orderTotalAmount) {
		OrderTotalAmount = orderTotalAmount;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	

}
