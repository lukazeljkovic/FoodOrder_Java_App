package model;

public class Restaurant {
	
	private int RestaurantID, RestaurantWorksFrom,RestaurantWorksTo;
	private String RestaurantUserName, RestaurantPassword,RestaurantName, RestaurantAdress, RestaurantContact;
	
	public Restaurant(int RestaurantID, String RestaurantUserName, String RestaurantPassword, String RestaurantName, String RestaurantAdress, String RestaurantContact, int RestaurantWorksFrom, int RestaurantWorksTo)
	{
		this.RestaurantID = RestaurantID;
		this.RestaurantWorksFrom = RestaurantWorksFrom;
		this.RestaurantWorksTo = RestaurantWorksTo;
		this.RestaurantUserName = RestaurantUserName;
		this.RestaurantPassword = RestaurantPassword;
		this.RestaurantName = RestaurantName;
		this.RestaurantAdress = RestaurantAdress;
		this.RestaurantContact = RestaurantContact;
	}
	
	public Restaurant(int RestaurantWorksFrom, int RestaurantWorksTo)
	{
		this.RestaurantWorksFrom = RestaurantWorksFrom;
		this.RestaurantWorksTo = RestaurantWorksTo;
	}
	
	/*public Restaurant(int RestaurantWorksFrom, int RestaurantWorksTo, String RestaurantUserName, String RestaurantPassword, String RestaurantName, String RestaurantAdress, String RestaurantContact)
	{
		this.RestaurantWorksFrom = RestaurantWorksFrom;
		this.RestaurantWorksTo = RestaurantWorksTo;
		this.RestaurantUserName = RestaurantUserName;
		this.RestaurantPassword = RestaurantPassword;
		this.RestaurantName = RestaurantName;
		this.RestaurantAdress = RestaurantAdress;
		this.RestaurantContact = RestaurantContact;
	} */
	
	public Restaurant()
	{
		
	}

	public int getRestaurantID() {
		return RestaurantID;
	}

	public void setRestaurantID(int restaurantID) {
		RestaurantID = restaurantID;
	}

	public int getRestaurantWorksFrom() {
		return RestaurantWorksFrom;
	}

	public void setRestaurantWorksFrom(int restaurantWorksFrom) {
		RestaurantWorksFrom = restaurantWorksFrom;
	}

	public int getRestaurantWorksTo() {
		return RestaurantWorksTo;
	}

	public void setRestaurantWorksTo(int restaurantWorksTo) {
		RestaurantWorksTo = restaurantWorksTo;
	}

	public String getRestaurantUserName() {
		return RestaurantUserName;
	}

	public void setRestaurantUserName(String restaurantUserName) {
		RestaurantUserName = restaurantUserName;
	}

	public String getRestaurantPassword() {
		return RestaurantPassword;
	}

	public void setRestaurantPassword(String restaurantPassword) {
		RestaurantPassword = restaurantPassword;
	}

	public String getRestaurantName() {
		return RestaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		RestaurantName = restaurantName;
	}

	public String getRestaurantAdress() {
		return RestaurantAdress;
	}

	public void setRestaurantAdress(String restaurantAdress) {
		RestaurantAdress = restaurantAdress;
	}

	public String getRestaurantContact() {
		return RestaurantContact;
	}

	public void setRestaurantContact(String restaurantContact) {
		RestaurantContact = restaurantContact;
	}

}
