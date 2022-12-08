package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import controller.OrderController;
import controller.RestaurantController;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import java.awt.ScrollPane;

public class RestaurantUI {

	private JFrame frame = new JFrame("Restaurant orders");
	JPanel panel = new JPanel();
	private OrderController orderController = new OrderController();
	private RestaurantController restaurantController = new RestaurantController();
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantUI window = new RestaurantUI();
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
	public RestaurantUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1086, 458);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnChangeStatus = new JButton("Change status");
		btnChangeStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1)
				{
					JOptionPane.showMessageDialog(null, "No order is selected!", "", JOptionPane.ERROR_MESSAGE);
					return;
				}
				OrderController.selectedOrderNumber = orderController.getSelectedOrderNumber(table.getSelectedRow());
				
				ChangeStatus changeStatus = new ChangeStatus();
				changeStatus.main(null);
				frame.dispose();
				
			}
		});
		
		
		
		
		//TABLE---------------------------------------------------
		String [] columnNames;
		columnNames   = new String [] {"Order number", "Order status", "Total price", "Customer", "Adress", "Contact", "Items"};
		String [][] data = orderController.getRestaurantOrdersTable();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 42, 960, 196);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
		
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		
		btnChangeStatus.setBounds(86, 292, 117, 23);
		frame.getContentPane().add(btnChangeStatus);
		
		JButton btnExportToTxt = new JButton("Export to .txt");
		btnExportToTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			restaurantController.OpenDialog(table, "txt");
			}
		});
		
		btnExportToTxt.setBounds(275, 292, 117, 23);
		frame.getContentPane().add(btnExportToTxt);
		

		JButton btnExportToExcel = new JButton("Export to Excel");
		btnExportToExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				restaurantController.OpenDialog(table, "xls");
			}
		});
		btnExportToExcel.setBounds(469, 292, 156, 23);
		frame.getContentPane().add(btnExportToExcel);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		
		
	}
}
