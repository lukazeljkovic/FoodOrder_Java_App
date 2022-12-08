package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import controller.ItemController;
import controller.LogInController;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RestaurantItemsUI {

	private JFrame frame;
	private JTable table;
	private ItemController itemController = new ItemController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantItemsUI window = new RestaurantItemsUI();
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
	public RestaurantItemsUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 661, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 27, 578, 168);
		frame.getContentPane().add(scrollPane);
		
		String [] columnNames = {"Item ID", "Item Name", "Item Price", "Item Category"};
		String [][] data = itemController.getItemsForRestaurant();
		
		table = new JTable(data,columnNames);
		
		scrollPane.setViewportView(table);
		
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		
		JButton btnAddItem = new JButton("Add item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateItemUI item = new CreateItemUI();
				CreateItemUI.main(null);
			}
		});
		btnAddItem.setBounds(94, 227, 89, 23);
		frame.getContentPane().add(btnAddItem);
		
		JButton btnSeeOrders = new JButton("See orders");
		btnSeeOrders.setBounds(400, 227, 109, 23);
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
		btnLogOut.setBounds(250, 227, 89, 23);
		frame.getContentPane().add(btnLogOut);
		btnSeeOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestaurantUI restaurant = new RestaurantUI();
				RestaurantUI.main(null);
			}
		});
	}
}
