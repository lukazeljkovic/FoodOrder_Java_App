package model;

public class Item_Order {
	
	private int OrderNumber, ItemID, Item_Order_Quantity;
	
	public Item_Order()
	{
		
	}
	
	public Item_Order(int OrderNumber, int ItemID, int Item_Order_Quantity)
	{
		this.OrderNumber = OrderNumber;
		this.ItemID = ItemID;
		this.Item_Order_Quantity = Item_Order_Quantity;
	}

	public int getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		OrderNumber = orderNumber;
	}

	public int getItemID() {
		return ItemID;
	}

	public void setItemID(int itemID) {
		ItemID = itemID;
	}

	public int getItem_Order_Quantity() {
		return Item_Order_Quantity;
	}

	public void setItem_Order_Quantity(int item_Order_Quantity) {
		Item_Order_Quantity = item_Order_Quantity;
	}

}
