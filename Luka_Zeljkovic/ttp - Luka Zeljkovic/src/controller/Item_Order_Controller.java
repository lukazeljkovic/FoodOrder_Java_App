package controller;

import model.Item_Order;

public class Item_Order_Controller {
	
	private DataBaseController db = DataBaseController.getInstance();
	
	public Item_Order_Controller()
	{
		
	}
	
	public void insertItem_Order (Item_Order io)
	{
		try
		{
			
		db.commitStatement(String.format("INSERT INTO Item_Order (ItemID, OrderNumber, Item_Order_Quantity) VALUES ('%s','%s','%s')",
				io.getItemID(),io.getOrderNumber(),io.getItem_Order_Quantity()
                )); 
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			
		}
	}

}
