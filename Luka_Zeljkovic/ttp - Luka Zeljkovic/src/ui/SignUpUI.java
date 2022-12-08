package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import controller.SignUpController;
import model.Customer;
import model.Restaurant;

import javax.swing.JButton;

public class SignUpUI {

	private JFrame frame;
	private JTextField textFieldUserName;
	private JTextField textFieldPassword;
	private JTextField textFieldName;
	private JTextField textFieldAdress;
	private JTextField textFieldSurrname;
	private JTextField textFieldContact;
	private JTextField textFieldWorkFrom;
	private JTextField textFieldWorkTo;
	private int typeOfUser = 0;
	private Customer customer = new Customer();
	private Restaurant restaurant = new Restaurant(0,24);
	private SignUpController signUp = new SignUpController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpUI window = new SignUpUI();
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
	public SignUpUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 584, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		
		JLabel lblNewLabel = new JLabel("Create an account");
		lblNewLabel.setBounds(161, 11, 183, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Type of user:");
		lblNewLabel_1.setBounds(54, 57, 75, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnCustomer = new JRadioButton("Customer");
		rdbtnCustomer.setBounds(155, 53, 109, 23);
		frame.getContentPane().add(rdbtnCustomer);
		
		JRadioButton rdbtnRestaurant = new JRadioButton("Restaurant");
		rdbtnRestaurant.setBounds(284, 53, 109, 23);
		frame.getContentPane().add(rdbtnRestaurant);
		
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(rdbtnRestaurant);
		bGroup.add(rdbtnCustomer);
		
		
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(123, 97, 86, 20);
		frame.getContentPane().add(textFieldUserName);
		textFieldUserName.setColumns(10);
		textFieldUserName.setVisible(false);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(357, 97, 86, 20);
		frame.getContentPane().add(textFieldPassword);
		textFieldPassword.setColumns(10);
		textFieldPassword.setVisible(false);
		
		JLabel lblUserName = new JLabel("Username*:");
		lblUserName.setBounds(26, 100, 103, 14);
		frame.getContentPane().add(lblUserName);
		lblUserName.setVisible(false);
		
		JLabel lblPassword = new JLabel("Password*:");
		lblPassword.setBounds(251, 100, 86, 14);
		frame.getContentPane().add(lblPassword);
		lblPassword.setVisible(false);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(123, 151, 86, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		textFieldName.setVisible(false);
		
		JLabel lblName = new JLabel("Name*:");
		lblName.setBounds(29, 154, 46, 14);
		frame.getContentPane().add(lblName);
		lblName.setVisible(false);
		
		textFieldAdress = new JTextField();
		textFieldAdress.setBounds(357, 151, 86, 20);
		frame.getContentPane().add(textFieldAdress);
		textFieldAdress.setColumns(10);
		textFieldAdress.setVisible(false);
		
		JLabel lblAdress = new JLabel("Adress*:");
		lblAdress.setBounds(251, 154, 75, 14);
		frame.getContentPane().add(lblAdress);
		lblAdress.setVisible(false);
		
		JLabel lblSurrname = new JLabel("Surrname*:");
		lblSurrname.setBounds(26, 208, 103, 14);
		frame.getContentPane().add(lblSurrname);
		lblSurrname.setVisible(false);
		
		textFieldSurrname = new JTextField();
		textFieldSurrname.setBounds(123, 205, 86, 20);
		frame.getContentPane().add(textFieldSurrname);
		textFieldSurrname.setColumns(10);
		textFieldSurrname.setVisible(false);
		
		JLabel lblContact = new JLabel("Contact*:");
		lblContact.setBounds(251, 208, 65, 14);
		frame.getContentPane().add(lblContact);
		lblContact.setVisible(false);
		
		textFieldContact = new JTextField();
		textFieldContact.setBounds(357, 205, 86, 20);
		frame.getContentPane().add(textFieldContact);
		textFieldContact.setColumns(10);
		textFieldContact.setVisible(false);
		
		JLabel lblWorkFrom = new JLabel("Working hour from:");
		lblWorkFrom.setBounds(10, 262, 133, 14);
		frame.getContentPane().add(lblWorkFrom);
		lblWorkFrom.setVisible(false);
		
		textFieldWorkFrom = new JTextField();
		textFieldWorkFrom.setBounds(153, 259, 86, 20);
		frame.getContentPane().add(textFieldWorkFrom);
		textFieldWorkFrom.setColumns(10);
		textFieldWorkFrom.setVisible(false);
		
		JLabel lblWorkTo = new JLabel("Working hour to:");
		lblWorkTo.setBounds(291, 259, 135, 14);
		frame.getContentPane().add(lblWorkTo);
		lblWorkTo.setVisible(false);
		
		textFieldWorkTo = new JTextField();
		textFieldWorkTo.setBounds(436, 259, 86, 20);
		frame.getContentPane().add(textFieldWorkTo);
		textFieldWorkTo.setColumns(10);
		
		JButton btnCreateAcc = new JButton("Create account");
		btnCreateAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int success = 0;
				if (typeOfUser == 1)
				{
					customer.setCustomerUserName(textFieldUserName.getText());
					customer.setCustomerPassword(textFieldPassword.getText());
					customer.setCustomerName(textFieldName.getText());
					customer.setCustomerSurrname(textFieldSurrname.getText());
					customer.setCustomerAdress(textFieldAdress.getText());
					customer.setCustomerContact(textFieldContact.getText());
					success = signUp.SignUpCustomer(customer);
					
					
				}
				
				else if (typeOfUser == 2)
				{
					restaurant.setRestaurantUserName(textFieldUserName.getText());
					restaurant.setRestaurantPassword(textFieldPassword.getText());
					restaurant.setRestaurantName(textFieldName.getText());
					restaurant.setRestaurantAdress(textFieldAdress.getText());
					restaurant.setRestaurantContact(textFieldContact.getText());
					if(!textFieldWorkFrom.getText().isEmpty() && !textFieldWorkTo.getText().isEmpty())
					{
					restaurant.setRestaurantWorksFrom(Integer.parseInt(textFieldWorkFrom.getText()));
					restaurant.setRestaurantWorksTo(Integer.parseInt(textFieldWorkTo.getText()));
					}
					success = signUp.SignUpRestaurant(restaurant);
					
					
					
				}
				
				if (success == 1) 
				{
					LogInUI logIn = new LogInUI();
					LogInUI.main(null);
					frame.setVisible(false);
				}
			}
		});
		btnCreateAcc.setBounds(204, 320, 133, 23);
		frame.getContentPane().add(btnCreateAcc);
		btnCreateAcc.setVisible(false);
		
		JLabel lblAlearadyHave = new JLabel("Already have an account?");
		lblAlearadyHave.setBounds(190, 357, 188, 14);
		frame.getContentPane().add(lblAlearadyHave);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInUI logIn = new LogInUI();
				LogInUI.main(null);
				frame.setVisible(false);
			}
		});
		btnLogIn.setBounds(204, 382, 133, 23);
		frame.getContentPane().add(btnLogIn);
		textFieldWorkTo.setVisible(false);
		
		rdbtnCustomer.addActionListener(new ActionListener() {
			 @Override
		        public void actionPerformed(ActionEvent e) {
				 lblWorkFrom.setVisible(false);
				 lblWorkTo.setVisible(false);
				 textFieldWorkFrom.setVisible(false);
				 textFieldWorkTo.setVisible(false);
				 lblSurrname.setVisible(true);
				 textFieldSurrname.setVisible(true);
				 textFieldUserName.setVisible(true);
				 textFieldPassword.setVisible(true);
				 lblUserName.setVisible(true);
				 lblPassword.setVisible(true);
				 textFieldName.setVisible(true);
				 lblName.setVisible(true);
				 textFieldAdress.setVisible(true);
				 lblAdress.setVisible(true);
				 lblSurrname.setVisible(true);
				 textFieldSurrname.setVisible(true);
				 lblContact.setVisible(true);
				 textFieldContact.setVisible(true);
				 btnCreateAcc.setVisible(true);
				 
				 typeOfUser = 1;

		        }
		});
		
		rdbtnRestaurant.addActionListener(new ActionListener() {
			 @Override
		        public void actionPerformed(ActionEvent e) {
				 
				 btnCreateAcc.setVisible(true);
				 textFieldWorkTo.setVisible(true);
				 lblWorkTo.setVisible(true);
				 textFieldWorkFrom.setVisible(true);
				 lblWorkFrom.setVisible(true);
				 textFieldContact.setVisible(true);
				 lblContact.setVisible(true);
				 textFieldSurrname.setVisible(true);
				 lblSurrname.setVisible(false);
				 lblAdress.setVisible(true);
				 textFieldAdress.setVisible(true);
				 lblName.setVisible(true);
				 textFieldName.setVisible(true);
				 lblPassword.setVisible(true);
				 lblUserName.setVisible(true);
				 textFieldPassword.setVisible(true);
				 textFieldUserName.setVisible(true);
				 lblWorkFrom.setVisible(true);
				 lblWorkTo.setVisible(true);
				 textFieldWorkFrom.setVisible(true);
				 textFieldWorkTo.setVisible(true);
				 lblSurrname.setVisible(false);
				 textFieldSurrname.setVisible(false);
				 
				 typeOfUser = 2;

		        }
		});
	}
}
