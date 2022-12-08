package model;

import java.util.ArrayList;

public class Item {

	private int ItemID, RestaurantID, ItemCategoryID, ItemPrice;
	private String ItemName;
	public static ArrayList<Integer> cart = new ArrayList<>();
	
	public Item(int ItemID, int RestaurantID, int ItemCategoryID, int ItemPrice,String ItemName)
	{
		this.ItemID = ItemID;
		this.RestaurantID = RestaurantID;
		this.ItemCategoryID = ItemCategoryID;
		this.ItemPrice = ItemPrice;
		this.ItemName = ItemName;
	}
	
	public Item()
	{
		
	}

	public int getItemID() {
		return ItemID;
	}

	public void setItemID(int itemID) {
		ItemID = itemID;
	}

	public int getRestaurantID() {
		return RestaurantID;
	}

	public void setRestaurantID(int restaurantID) {
		RestaurantID = restaurantID;
	}

	public int getItemCategoryID() {
		return ItemCategoryID;
	}

	public void setItemCategoryID(int itemCategoryID) {
		ItemCategoryID = itemCategoryID;
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
}
