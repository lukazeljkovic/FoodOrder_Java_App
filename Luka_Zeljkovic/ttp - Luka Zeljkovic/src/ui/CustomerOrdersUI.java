package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JRootPane;

import controller.OrderController;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerOrdersUI {

	private JFrame frame;
	
	private OrderController orderController = new OrderController();
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerOrdersUI window = new CustomerOrdersUI();
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
	public CustomerOrdersUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 671, 330);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnClose.setBounds(285, 227, 89, 23);
		frame.getContentPane().add(btnClose);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 613, 179);
		frame.getContentPane().add(scrollPane);
		
		String[] columnNames = {"Order number","Total ammount", "Items"};
		String[][] data = orderController.getCustomersOrdersTable();
		
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
		
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
	}
}
