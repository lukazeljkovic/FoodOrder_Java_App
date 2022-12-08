package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;

import controller.OrderController;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeStatus {

	private JFrame frame;
	private OrderController orderController = new OrderController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeStatus window = new ChangeStatus();
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
	public ChangeStatus() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 330);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Order status");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(42, 85, 107, 74);
		frame.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnActive = new JRadioButton("Active");
		rdbtnActive.setBounds(182, 48, 109, 23);
		frame.getContentPane().add(rdbtnActive);
		
		JRadioButton rdbtnInactive = new JRadioButton("Inactive");
		rdbtnInactive.setBounds(182, 114, 109, 23);
		frame.getContentPane().add(rdbtnInactive);
		
		JRadioButton rdbtnPayed = new JRadioButton("Payed");
		rdbtnPayed.setBounds(182, 180, 109, 23);
		frame.getContentPane().add(rdbtnPayed);
		
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(rdbtnActive);
		bGroup.add(rdbtnInactive);
		bGroup.add(rdbtnPayed);
		
		if(OrderController.orderStatus == 1)
		{
			rdbtnInactive.setSelected(true);
			rdbtnActive.setSelected(false);
			rdbtnPayed.setSelected(false);
		}
		else if (OrderController.orderStatus == 2)
		{
			rdbtnActive.setSelected(true);
			rdbtnInactive.setSelected(false);
			rdbtnPayed.setSelected(false);
		}
		else if (OrderController.orderStatus == 3)
		{
			rdbtnPayed.setSelected(true);
			rdbtnActive.setSelected(false);
			rdbtnInactive.setSelected(false);
		}
		
		rdbtnPayed.setSelected(false);
		
		JButton btnNewButton = new JButton("Change");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnActive.isSelected())
				{
					orderController.setStatus(2);
				}
				else if (rdbtnInactive.isSelected())
				{
					orderController.setStatus(1);
				}
				else
				{
					orderController.setStatus(3);
				}
				RestaurantUI item = new RestaurantUI();
				RestaurantUI.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(165, 242, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
	}
}
