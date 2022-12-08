package model;

public class OrderRestaurantDTO {
	
	private int OrderNumber, Item_Order_Quantity, OrderTotalAmmount;
	private String ItemName, CustomerName, CustomerSurrname, CustomerAdress, CustomerContact, OrderStatusName;
	
	public OrderRestaurantDTO(int OrderNumber, int Item_Order_Quantity, int OrderTotalAmmount, String ItemName, String CustomerName, String CustomerSurrname, String CustomerAdress, String CustomerContact, String OrderStatusName)
	{
		this.OrderNumber = OrderNumber;
		this.Item_Order_Quantity = Item_Order_Quantity;
		this.OrderTotalAmmount = OrderTotalAmmount;
		this.ItemName = ItemName;
		this.CustomerName = CustomerName;
		this.CustomerSurrname = CustomerSurrname;
		this.CustomerAdress = CustomerAdress;
		this.CustomerContact = CustomerContact;
		this.OrderStatusName = OrderStatusName;
	}

	public String getOrderStatusName() {
		return OrderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		OrderStatusName = orderStatusName;
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
		OrderTotalAmmount = orderTotalAmmount;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getCustomerSurrname() {
		return CustomerSurrname;
	}

	public void setCustomerSurrname(String customerSurrname) {
		CustomerSurrname = customerSurrname;
	}

	public String getCustomerAdress() {
		return CustomerAdress;
	}

	public void setCustomerAdress(String customerAdress) {
		CustomerAdress = customerAdress;
	}

	public String getCustomerContact() {
		return CustomerContact;
	}

	public void setCustomerContact(String customerContact) {
		CustomerContact = customerContact;
	}
	
	

}
