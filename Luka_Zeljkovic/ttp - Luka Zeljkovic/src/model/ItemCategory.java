package model;

public class ItemCategory {
	
	private int ItemCategoryID;
	private String ItemCategoryName;
	
	public ItemCategory(int ItemCategoryID, String ItemCategoryName)
	{
		this.ItemCategoryID = ItemCategoryID;
		this.ItemCategoryName = ItemCategoryName;
	}

	public int getItemCategoryID() {
		return ItemCategoryID;
	}

	public void setItemCategoryID(int itemCategoryID) {
		ItemCategoryID = itemCategoryID;
	}

	public String getItemCategoryName() {
		return ItemCategoryName;
	}

	public void setItemCategoryName(String itemCategoryName) {
		ItemCategoryName = itemCategoryName;
	}

}
