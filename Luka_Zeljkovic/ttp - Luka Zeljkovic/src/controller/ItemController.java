package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import model.Customer;
import model.Item;
import model.ItemCategory;
import model.ItemRestaurantDTO;
import model.OrderRestaurantDTO;
import model.Restaurant;

public class ItemController {
	
	private ArrayList<Item> itemList;
	
	private ArrayList<ItemCategory> itemCategoryList;
	
	private DataBaseController db = DataBaseController.getInstance();
	
	
	public ItemController()
	{
		populateLists();
	}
	
	
	
	
	
	private void populateLists() {
		
		itemList = new ArrayList<Item>();
		itemCategoryList = new ArrayList<ItemCategory>();
		
		try 
		{
			PreparedStatement psi = db.getConnection().prepareStatement("SELECT * FROM Item");  
            ResultSet rsi = psi.executeQuery();  
              
            Item item; 
            
            while(rsi.next())
            {
            	item = new Item(rsi.getInt("ItemID"),
            					rsi.getInt("RestaurantID"),
            					rsi.getInt("ItemCategoryID"),
            					rsi.getInt("ItemPrice"),
            					rsi.getString("ItemName"));
            	
            	itemList.add(item);
            }
            
            PreparedStatement psic = db.getConnection().prepareStatement("SELECT * FROM ItemCategory");  
            ResultSet rsic = psic.executeQuery();  
              
            ItemCategory itemCategory;
            
            while (rsic.next())
            {
            	itemCategory = new ItemCategory(rsic.getInt("ItemCategoryID"), rsic.getString("ItemCategoryName"));
            	
            	itemCategoryList.add(itemCategory);
            }
            
		}
		catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
       }  
	}
	
	public HashMap<Integer,String> getCategories()
	{
		HashMap <Integer,String> map = new HashMap<>();
		for (ItemCategory ic : itemCategoryList)
		{
			
			map.put(ic.getItemCategoryID(), ic.getItemCategoryName());
		}
		
		return map;
	}
	
	public void InsertItem(Item item)
	{
		try
		{
			if(item.getItemName().equals("") && item.getItemPrice() == 0)
			{
				JOptionPane.showMessageDialog(null, "Fields with * are mandatory!", "", JOptionPane.ERROR_MESSAGE);
				
			}
		db.commitStatement(String.format("INSERT INTO Item (RestaurantID, ItemCategoryID, ItemName, ItemPrice) VALUES ('%s','%s','%s','%s')",
				item.getRestaurantID(),item.getItemCategoryID(),item.getItemName(),item.getItemPrice()
                )); 
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			
		}
	}
	
	public int getRestaurantIDbyName(String restaurantName)
	{
		int RestaurantID = 0;
		try
		{
			String query = "SELECT RestaurantID FROM Restaurant WHERE RestaurantName= '" + restaurantName + "'";
			PreparedStatement pssr = db.getConnection().prepareStatement(query);
			ResultSet rssr = pssr.executeQuery();
			RestaurantID = rssr.getInt("RestaurantID");
			
		}
		catch(Exception ex)
		{
			
		}
		return RestaurantID;
	}
	
	public ArrayList<Item> getItemsByRestaurantName(String restaurantName)
	{
		restaurantName = restaurantName.split("-")[0];
		int restaurantID = getRestaurantIDbyName(restaurantName);
		ArrayList<Item> selectedItems = new ArrayList<Item>();
		try
		{
			
			
			String query = "SELECT * FROM Item WHERE RestaurantID = " + restaurantID;
			PreparedStatement pssi = db.getConnection().prepareStatement(query);  
            ResultSet rssi = pssi.executeQuery();  
              
            Item item; 
            
            while(rssi.next())
            {
            	item = new Item(rssi.getInt("ItemID"),
            					rssi.getInt("RestaurantID"),
            					rssi.getInt("ItemCategoryID"),
            					rssi.getInt("ItemPrice"),
            					rssi.getString("ItemName"));
            	
            	selectedItems.add(item);         }
            
           return selectedItems;
            
		}
		catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
            return new ArrayList<Item>();
       }  
		
	}
	
	public int getIDbyItemName(String name)
	{
		try {
		String query = "SELECT ItemID FROM Item WHERE ItemName = '" + name + "'";
		PreparedStatement pssi = db.getConnection().prepareStatement(query);  
        ResultSet rssi = pssi.executeQuery();
        return rssi.getInt(1);
		}
		catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
            return 0;
       }  
	}
	
	public String [][] getItemsForRestaurant()
	{
		String [][] arr;
		ArrayList<ItemRestaurantDTO> items = new ArrayList<>();
		int iterator = 0;
		
		
		try 
		{
			PreparedStatement psi = db.getConnection().prepareStatement("SELECT ItemID,\r\n"
					+ "       ItemCategory.ItemCategoryName,\r\n"
					+ "       ItemName,\r\n"
					+ "       ItemPrice\r\n"
					+ "  FROM Item\r\n"
					+ "  JOIN ItemCategory ON Item.ItemCategoryID = ItemCategory.ItemCategoryID\r\n"
					+ "  WHERE RestaurantID =" + LogInController.currUser);  
            ResultSet rsi = psi.executeQuery();  
              
            ItemRestaurantDTO itemDto; 
            
            while(rsi.next())
            {
            	itemDto = new ItemRestaurantDTO(rsi.getInt("ItemID"),
            					rsi.getInt("ItemPrice"),
            					rsi.getString("ItemName"),
            					rsi.getString("ItemCategoryName")
            					
            					);
            	
          
            	items.add(itemDto);
            	iterator++;
            	
            }
            
           
	}
		catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
       } 
		int i = 0;
		int k = 0;
		arr = new String [iterator][4];
		for(ItemRestaurantDTO item : items)
		{
			arr[i][0] = String.valueOf(item.getItemID());
			arr[i][1] = item.getItemName();
			arr[i][2] = String.valueOf(item.getItemPrice());
			arr[i][3] = item.getItemCategoryName();
			i++;
		}
		
		return arr;
	}

}
