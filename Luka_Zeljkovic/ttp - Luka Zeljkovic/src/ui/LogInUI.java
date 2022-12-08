package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.LogInController;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;

public class LogInUI {

	private JFrame frame;
	private JTextField txtUserName;
	private LogInController logInController = new LogInController();
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInUI window = new LogInUI();
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
	public LogInUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//LOGGING IN
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUserName.getText();
				String password = txtPassword.getText();
				
				int auth = logInController.authenticate(username, password);
				
				// 1 is for customers
				if(auth == 1)
				{
				CustomerUI customer = new CustomerUI();
				CustomerUI.main(null);
				frame.setVisible(false);
				}
				//2 is for restaurants
				else if (auth == 2)
				{
					
					RestaurantItemsUI item = new RestaurantItemsUI();
					RestaurantItemsUI.main(null);
					frame.setVisible(false);
				}
				else if (auth ==0)
				{
					
					JOptionPane.showMessageDialog(btnLogIn, "Username and password doesn't match", "Error", 0, null);
				}
			}
		});
		btnLogIn.setBounds(162, 151, 89, 23);
		frame.getContentPane().add(btnLogIn);
		
		//SIGN UP
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpUI logIn = new SignUpUI();
				SignUpUI.main(null);
				frame.setVisible(false);
			}
		});
		btnSignUp.setBounds(150, 227, 120, 23);
		frame.getContentPane().add(btnSignUp);
		
		JLabel lblDontHaveAnAcc = new JLabel("Don't have an account?");
		lblDontHaveAnAcc.setBounds(150, 202, 163, 14);
		frame.getContentPane().add(lblDontHaveAnAcc);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(162, 89, 179, 20);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblUserName = new JLabel("Username:");
		lblUserName.setBounds(78, 92, 74, 14);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(78, 123, 74, 14);
		frame.getContentPane().add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(162, 120, 179, 20);
		frame.getContentPane().add(txtPassword);
		
		 frame.setUndecorated(true);
		 frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
	}
}
