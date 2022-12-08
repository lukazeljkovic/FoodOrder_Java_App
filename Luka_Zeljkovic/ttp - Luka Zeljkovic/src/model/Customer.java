package model;

public class Customer {
	
	private int CustomerID;
	private String CustomerUserName,
				   CustomerPassword,
				   CustomerName,
				   CustomerSurrname,
				   CustomerAdress,
				   CustomerContact;
	
	public Customer(int CustomerID, String CustomerUserName, String CustomerPassword, String CustomerName, String CustomerSurrname, String CustomerAdress, String CustomerContact )
	{
		this.CustomerID = CustomerID;
		this.CustomerUserName = CustomerUserName;
		this.CustomerPassword = CustomerPassword;
		this.CustomerName = CustomerName;
		this.CustomerSurrname = CustomerSurrname;
		this.CustomerAdress = CustomerAdress;
		this.CustomerContact = CustomerContact;
	}
	
	/*public Customer(String CustomerUserName, String CustomerPassword, String CustomerName, String CustomerSurrname, String CustomerAdress, String CustomerContact )
	{
		
		this.CustomerUserName = CustomerUserName;
		this.CustomerPassword = CustomerPassword;
		this.CustomerName = CustomerName;
		this.CustomerSurrname = CustomerSurrname;
		this.CustomerAdress = CustomerAdress;
		this.CustomerContact = CustomerContact;
	} */
	
	public Customer()
	{
		
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public String getCustomerUserName() {
		return CustomerUserName;
	}

	public void setCustomerUserName(String customerUserName) {
		CustomerUserName = customerUserName;
	}

	public String getCustomerPassword() {
		return CustomerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		CustomerPassword = customerPassword;
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
