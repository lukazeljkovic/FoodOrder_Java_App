package ui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.ListModel;

import controller.ItemController;
import controller.Item_Order_Controller;
import controller.LogInController;
import controller.OrderController;
import controller.RestaurantController;
import model.Item;
import model.Item_Order;
import model.Order;
import model.Restaurant;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class CustomerUI {

	private JFrame frame;
	private RestaurantController restaurantController = new RestaurantController();
	private ItemController itemController = new ItemController();
	private OrderController orderController = new OrderController();
	private Item_Order_Controller item_order_controller = new Item_Order_Controller();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerUI window = new CustomerUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1026, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		// LISTING THE RESTAURANTS
		
		// ----------------------------------------------------------------
		
		
		DefaultListModel listModelRestaurants = restaurantController.getRestaurantsForCustomerUI();
		
		JList listRestaurants = new JList(listModelRestaurants);
		listRestaurants.setBounds(10, 57, 259, 150);
		frame.getContentPane().add(listRestaurants);
		
		//---------------------------------------------------------------------
		
		
		//SHOWING THE MENU
		
		
		//---------------------------------------------------------------------------------------------
		
		DefaultListModel listModelCart = new DefaultListModel();
		DefaultListModel listModelItems = new DefaultListModel();
		JButton btnShowMenu = new JButton("Show menu");
		btnShowMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModelCart.clear();
				listModelItems.clear();
				if (listRestaurants.getSelectedValue() == null)
				{
					JOptionPane.showMessageDialog(null, "No restaurant is selected!", "", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String restaurantName = listRestaurants.getSelectedValue().toString();
				ArrayList<Item> itemList = new ArrayList<>();
				itemList = itemController.getItemsByRestaurantName(restaurantName);
				for (Item item : itemList)
				{
					listModelItems.addElement(item.getItemName() + "     Price:" + item.getItemPrice());
				}
			}
		});
		btnShowMenu.setBounds(20, 256, 128, 23);
		frame.getContentPane().add(btnShowMenu);
		
		
		JList listItems = new JList(listModelItems);
		listItems.setBounds(332, 57, 259, 150);
		frame.getContentPane().add(listItems);
		
		//--------------------------------------------------------------------------------------------------
		
		
		
		
		//ADDING TO CART
		
		//------------------------------------------------------------------------
		
		int[] cartPrice = {0};
		int[] cartQuantity = {0};
		
		JLabel lblCartPrice = new JLabel(Integer.toString(cartPrice[0]));
		lblCartPrice.setBounds(742, 218, 135, 14);
		frame.getContentPane().add(lblCartPrice);
		
		
		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(listItems.getSelectedValue() == null)
				{
					JOptionPane.showMessageDialog(null, "No item is selected!", "", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				String selectedItem = listItems.getSelectedValue().toString();
				
				
				listModelCart.addElement(selectedItem);
				String[] arrOfStr = selectedItem.split(":", 2);
				cartPrice[0] = cartPrice[0] + Integer.parseInt(arrOfStr[1]);
				cartQuantity[0] = cartQuantity[0] + 1;
				lblCartPrice.setText(Integer.toString(cartPrice[0]));
			}
		});
		btnAddToCart.setBounds(395, 256, 128, 23);
		frame.getContentPane().add(btnAddToCart);
		
		
		JList listCart = new JList(listModelCart);
		listCart.setBounds(654, 57, 259, 150);
		frame.getContentPane().add(listCart);
		
		//-------------------------------------------------------------------------------
		
		
		
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInUI logIn = new LogInUI();
				LogInUI.main(null);
				frame.setVisible(false);
			}
		});
		btnLogIn.setBounds(20, 314, 128, 23);
		frame.getContentPane().add(btnLogIn);
		
		
		//SENDING THE ORDER
		
		//-----------------------------------------------------------
		
		JButton btnAddToOrder = new JButton("Order");
		btnAddToOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(listModelCart.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Cart is empty, there is nothih to order!", "", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				//ORDER
				
				int orderNumber = Math.abs(ThreadLocalRandom.current().nextInt());
				Date todayDate = new Date(Calendar.getInstance().getTime().getTime());
				Order order = new Order();
				
				order.setOrderNumber(orderNumber);
				order.setOrderDate(todayDate);
				order.setCustomerID(LogInController.currUser);
				order.setOrderStatusID(2);
				order.setOrderTotalAmount(cartPrice[0]);
				
				orderController.insertOrder(order);
				
				
				
				//ORDER_ITEM
				
				ArrayList<String> cartItems = new ArrayList<>();
				for(int i = 0; i<listModelCart.size(); i++)
				{
					String [] items = listModelCart.getElementAt(i).toString().split("     ", 2);
					cartItems.add(items[0]);
				}
				Set<String> set = new HashSet<String>(cartItems);
			    for (String r : set) {
			    	Item_Order item_order = new Item_Order();
			    	item_order.setOrderNumber(orderNumber);
			    	item_order.setItem_Order_Quantity(Collections.frequency(cartItems, r));
			        item_order.setItemID(itemController.getIDbyItemName(r));
			        
			        item_order_controller.insertItem_Order(item_order);
			        
			    }
			    
			    cartPrice[0] = 0;
			    lblCartPrice.setText(Integer.toString(cartPrice[0]));
			    listModelCart.clear();
			    
			    JOptionPane.showMessageDialog(null, "Your order has been sent!", "", JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		});
		
		
		//------------------------------------------------------------------
		btnAddToOrder.setBounds(732, 256, 128, 23);
		frame.getContentPane().add(btnAddToOrder);
		
		JLabel lblNewLabel = new JLabel("Restaurants");
		lblNewLabel.setBounds(94, 32, 102, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Items");
		lblNewLabel_1.setBounds(431, 32, 92, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cart");
		lblNewLabel_2.setBounds(761, 32, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cart price:");
		lblNewLabel_3.setBounds(661, 218, 71, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnSeeOrders = new JButton("Previous orders");
		btnSeeOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CustomerOrdersUI customerOrders = new CustomerOrdersUI();
				CustomerOrdersUI.main(null);
			}
		});
		btnSeeOrders.setBounds(395, 314, 128, 23);
		frame.getContentPane().add(btnSeeOrders);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInController.currUser = 0;
				LogInUI logIn = new LogInUI();
				LogInUI.main(null);
				frame.setVisible(false);
			}
		});
		btnLogOut.setBounds(732, 314, 128, 23);
		frame.getContentPane().add(btnLogOut);
		
		
		
		if(LogInController.currUser == 0)
		{
		btnAddToCart.setVisible(false);
		btnLogIn.setVisible(true);
		btnAddToOrder.setVisible(false);
		btnSeeOrders.setVisible(false);
		btnLogOut.setVisible(false);
		
		}	
		else if(LogInController.currUser != 0)
		{
			btnLogIn.setVisible(false);
			btnAddToCart.setVisible(true);
			btnAddToOrder.setVisible(true);
			btnSeeOrders.setVisible(true);
			btnLogOut.setVisible(true);
		}
		
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		
	}
}
