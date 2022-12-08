package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import model.Item;
import model.Order;
import model.OrderCustomerDTO;
import model.OrderRestaurantDTO;

public class OrderController {
	
	private ArrayList<Order> orderList = new ArrayList<>();
	private DataBaseController db = DataBaseController.getInstance();
	public static int orderStatus;
	public static int selectedOrderNumber;
	private String [] [] arrR;
	private String [] [] arrC;
	
	public OrderController()
	{
		
	}
	
	public void insertOrder(Order order)
	{
		try
		{
			
		db.commitStatement(String.format("INSERT INTO [Order] (OrderNumber, CustomerID, OrderStatusID, OrderTotalAmmount, OrderDate) VALUES ('%s','%s','%s','%s','%s')",
				order.getOrderNumber(), order.getCustomerID(),order.getOrderStatusID(),order.getOrderTotalAmount(),order.getOrderDate()
                )); 
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			
		}
	}
	
	public void insertOrderTable(Order order)
	{
		try
		{
			
		db.commitStatement(String.format("INSERT INTO [Order] (OrderNumber, CustomerID, OrderStatusID, OrderTotalAmmount, OrderDate) VALUES ('%s','%s','%s','%s','%s')",
				order.getOrderNumber(), order.getCustomerID(),order.getOrderStatusID(),order.getOrderTotalAmount(),order.getOrderDate()
                )); 
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			
		}
	}
	
	
	
	public String[][] getCustomersOrdersTable()
	{
		 ArrayList<OrderCustomerDTO> ordersDTO = new ArrayList<>();
		 try 
			{
				PreparedStatement pso = db.getConnection().prepareStatement("SELECT [Order].OrderNumber,  Item_Order.Item_Order_Quantity, Item.ItemName, [Order].OrderTotalAmmount\r\n"
						+ "  FROM [Order]\r\n"
						+ "  JOIN Item_Order ON [Order].OrderNumber = Item_Order.OrderNumber\r\n"
						+ "  JOIN Item ON [Item_Order].ItemID = Item.ItemID\r\n"
						+ "  WHERE [Order].CustomerID = " + LogInController.currUser);  
	            ResultSet rso = pso.executeQuery();  
	              
	            OrderCustomerDTO orderDto; 
	            
	            while(rso.next())
	            {
	            	orderDto = new OrderCustomerDTO(rso.getInt("OrderNumber"),
	            					rso.getInt("OrderTotalAmmount"),
	            					rso.getInt("Item_Order_Quantity"),
	            					rso.getString("ItemName")
	            					);
	            	
	            	ordersDTO.add(orderDto);
	            	
	            }
	            
	           
		}
			catch (SQLException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	       } 
		//Getting the information from Order table, Item table, Item_Order table which I later use to display the orders
		HashMap<Integer, String> map = new HashMap<>();
		HashMap<Integer, String> map2 = new HashMap<>();
		 for (OrderCustomerDTO o : ordersDTO)
		 {
			 if(map.isEmpty())
			 {
				 
				 
				 String s = o.getOrderNumber()  + "#"  + o.getOrderTotalAmmount()   +"#" + o.getItemName() + " x " + o.getItem_Order_Quantity();
				 map.put(o.getOrderNumber(), s);
				 map2.put(o.getOrderNumber(), s);
			 }
			 
			 else if (!map.isEmpty())
			 {
				 
				 for (Integer key : map.keySet())
				 {
					 if(o.getOrderNumber() == key)
					 {
						 String s = map.get(key) + " " + o.getItemName() + " x " + o.getItem_Order_Quantity();
						 map2.put(key, s);
						 
					 }
					 
					 else 
					 {
						 String s = o.getOrderNumber()  + "#" + o.getOrderTotalAmmount() + "#"  + o.getItemName() + " x " + o.getItem_Order_Quantity();
						 map2.put(o.getOrderNumber(), s);
					 }
					 
				 }
				 map.clear();
				 for (Integer key : map2.keySet())
				 {
					 map.put(key, map2.get(key));
					 
					 
				 }
				 			 
			 }
		 }
		 
		 int i = 0;
			arrC = new String [map.size()] [3];
			for(Integer key : map.keySet())
			 {
				 for (int k = 0; k<3 ; k++)
				 {
					 
					 arrC[i][k] = map.get(key).split("#")[k];
				 }
				 i++;
			 }
			 
			 return arrC;
		
		
	} 
	
	
	public String[][] getRestaurantOrdersTable()
	{
		ArrayList<OrderRestaurantDTO> ordersDTO = new ArrayList<>();
		
		try 
		{
			PreparedStatement pso = db.getConnection().prepareStatement("SELECT [Order].OrderNumber,  Item_Order.Item_Order_Quantity, Item.ItemName, [Order].OrderTotalAmmount, Customer.CustomerName, Customer.CustomerSurrname, Customer.CustomerAdress, Customer.CustomerContact, OrderStatus.OrderStatusName\r\n"
					+ "FROM [Order]\r\n"
					+ "JOIN Item_Order ON [Order].OrderNumber = Item_Order.OrderNumber\r\n"
					+ "JOIN Customer ON [Order].CustomerID = Customer.CustomerID\r\n"
					+ "JOIN Item ON [Item_Order].ItemID = Item.ItemID\r\n"
					+ "JOIN Restaurant ON Item.RestaurantID = Restaurant.RestaurantID\r\n"
					+ "JOIN OrderStatus ON [Order].OrderStatusID = OrderStatus.OrderStatusID\r\n"
					+ "WHERE Restaurant.RestaurantID = " + LogInController.currUser);  
            ResultSet rso = pso.executeQuery();  
              
            OrderRestaurantDTO orderDto; 
            
            while(rso.next())
            {
            	orderDto = new OrderRestaurantDTO(rso.getInt("OrderNumber"),
            					rso.getInt("Item_Order_Quantity"),
            					rso.getInt("OrderTotalAmmount"),
            					rso.getString("ItemName"),
            					rso.getString("CustomerName"),
            					rso.getString("CustomerSurrname"),
            					rso.getString("CustomerAdress"),
            					rso.getString("CustomerAdress"),
            					rso.getString("OrderStatusName")
            					);
            	
            	ordersDTO.add(orderDto);
            	
            }
            
           
	}
		catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
       } 
		
		HashMap<Integer, String> map = new HashMap<>();
		HashMap<Integer, String> map2 = new HashMap<>();
		
		
		
		for (OrderRestaurantDTO o : ordersDTO)
		{
			if(map.isEmpty())
			 { 
				String s = o.getOrderNumber()  + "#" + o.getOrderStatusName() + "#"  + o.getOrderTotalAmmount()   + "#" 
			    + o.getCustomerName() + " " + o.getCustomerSurrname() + "#" + o.getCustomerAdress() + "#"  
				+ o.getCustomerContact()  +"#" + o.getItemName() + " x " + o.getItem_Order_Quantity();
				map.put(o.getOrderNumber(), s);
				map2.put(o.getOrderNumber(), s);
			 }
			
			else if (!map.isEmpty())
			 {
				 
				 for (Integer key : map.keySet())
				 {
					 if(o.getOrderNumber() == key)
					 {
						 String s = map.get(key) + " " + o.getItemName() + " x " + o.getItem_Order_Quantity();
						 map2.put(key, s);
						 
					 }
					 
					 else 
					 {
						 String s = o.getOrderNumber()  + "#" + o.getOrderStatusName() + "#"  + o.getOrderTotalAmmount()   + "#" 
						 + o.getCustomerName() + " " + o.getCustomerSurrname() + " #" + o.getCustomerAdress() + "#"  
						 + o.getCustomerContact()  +"#" + o.getItemName() + "#" + o.getItem_Order_Quantity();
						 map2.put(o.getOrderNumber(), s);
					 }
					 
				 }
				 map.clear();
				 for (Integer key : map2.keySet())
				 {
					 map.put(key, map2.get(key));
					 
				 }
				 			 
			 }
		}
		int i = 0;
		arrR = new String [map.size()] [7];
		for(Integer key : map.keySet())
		 {
			 for (int k = 0; k<7 ; k++)
			 {
				 
				 arrR[i][k] = map.get(key).split("#")[k];
			 }
			 i++;
		 }
		 
		 return arrR;
	}
	
	
	
	
	public void getStatus(int row)
	{
		
		String status = arrR[row][1];
		
		try {
			PreparedStatement pso = db.getConnection().prepareStatement("Select OrderStatusID FROM OrderStatus WHERE OrderStatusName = " + "'" + status + "'");
			ResultSet rso = pso.executeQuery();
			orderStatus = rso.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	
	public int getSelectedOrderNumber (int row)
	{
		return Integer.parseInt(arrR[row][0]);
	}
	
	
	public void setStatus(int statusID )
	{
		try
		{
			
		db.commitStatement(String.format("UPDATE [ORDER] SET OrderStatusID = '%s' WHERE OrderNumber = '%s'", statusID, selectedOrderNumber
				
                )); 
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			
		}
	}
	
}
