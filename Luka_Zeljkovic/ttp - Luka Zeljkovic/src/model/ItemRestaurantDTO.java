package model;

public class ItemRestaurantDTO {
	
	private int ItemID, ItemPrice;
	private String ItemName, ItemCategoryName;
	
	public ItemRestaurantDTO(int ItemID, int ItemPrice, String ItemName, String ItemCategoryName)
	{
		this.ItemID = ItemID;
		this.ItemPrice = ItemPrice;
		this.ItemName = ItemName;
		this.ItemCategoryName = ItemCategoryName;
	}

	public int getItemID() {
		return ItemID;
	}

	public void setItemID(int itemID) {
		ItemID = itemID;
	}

	public int getItemPrice() {
		return ItemPrice;
	}

	public void setItemPrice(int itemPrice) {
		ItemPrice = itemPrice;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public String getItemCategoryName() {
		return ItemCategoryName;
	}

	public void setItemCategoryName(String itemCategoryName) {
		ItemCategoryName = itemCategoryName;
	}
	
	

}
