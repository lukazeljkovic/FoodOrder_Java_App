package ui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ItemController;
import controller.LogInController;
import model.Item;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRootPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.awt.event.ActionEvent;

public class CreateItemUI {

	private JFrame frame;
	private JTextField textFieldItemName;
	private JTextField textFieldItemPrice;
	private ItemController itemController = new ItemController();
	private LogInController logInController = new LogInController();
	private Item item = new Item();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateItemUI window = new CreateItemUI();
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
	public CreateItemUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 457, 377);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create an item");
		lblNewLabel.setBounds(159, 11, 105, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblItemName = new JLabel("Item name:");
		lblItemName.setBounds(40, 72, 81, 14);
		frame.getContentPane().add(lblItemName);
		
		textFieldItemName = new JTextField();
		textFieldItemName.setBounds(159, 69, 86, 20);
		frame.getContentPane().add(textFieldItemName);
		textFieldItemName.setColumns(10);
		
		JLabel lblItemPrice = new JLabel("Item price:");
		lblItemPrice.setBounds(40, 132, 93, 14);
		frame.getContentPane().add(lblItemPrice);
		
		textFieldItemPrice = new JTextField();
		textFieldItemPrice.setBounds(159, 129, 86, 20);
		frame.getContentPane().add(textFieldItemPrice);
		textFieldItemPrice.setColumns(10);
		
		JLabel lblItemCategory = new JLabel("Item category");
		lblItemCategory.setBounds(40, 192, 93, 14);
		frame.getContentPane().add(lblItemCategory);
		
		
		HashMap<Integer, String> map = itemController.getCategories();
		Object [] s1 = map.values().toArray();
		JComboBox comboBox = new JComboBox(s1);
		comboBox.setBounds(159, 188, 136, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnCreateItem = new JButton("Create");
		btnCreateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				item.setRestaurantID(logInController.currUser);
				item.setItemName(textFieldItemName.getText());
				item.setItemPrice(Integer.parseInt(textFieldItemPrice.getText()));
				item.setItemCategoryID((Integer) Array.get(map.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), comboBox.getSelectedItem()))
						.map(Map.Entry::getKey).collect(Collectors.toSet()).toArray(),0));
				
				itemController.InsertItem(item);
				RestaurantItemsUI item = new RestaurantItemsUI();
				RestaurantItemsUI.main(null);
				frame.dispose();
				
			}
		});
		btnCreateItem.setBounds(156, 266, 89, 23);
		frame.getContentPane().add(btnCreateItem);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
	}
}
