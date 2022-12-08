package model;

import java.sql.Date;

public class OrderCustomerDTO {
	
	private int OrderNumber, Item_Order_Quantity, OrderTotalAmmount;
	private String ItemName;
	
	public OrderCustomerDTO(int OrderNumber, int OrderTotalAmmount, int Item_Order_Quantity, String ItemName)
	{
		this.OrderNumber = OrderNumber;
		this.OrderTotalAmmount = OrderTotalAmmount;
		this.Item_Order_Quantity = Item_Order_Quantity;
		this.ItemName = ItemName;
	}
	
	public OrderCustomerDTO()
	{
		
	}

	public int getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		OrderNumber = orderNumber;
	}

	public int getItem_Order_Quantity() {
		return Item_Order_Quantity;
	}

	public void setItem_Order_Quantity(int item_Order_Quantity) {
		Item_Order_Quantity = item_Order_Quantity;
	}

	public int getOrderTotalAmmount() {
		return OrderTotalAmmount;
	}

	public void setOrderTotalAmmount(int orderTotalAmmount) {
		OrderNumber = orderTotalAmmount;
	}


	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	
	

}
