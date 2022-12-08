package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import model.Restaurant;



public class RestaurantController {
	
	private ArrayList<Restaurant> restaurantList = new ArrayList<>();
	private DataBaseController db = DataBaseController.getInstance();

	private int selectedOrderNumber = 1;
	
	public RestaurantController()
	{
		
		populateList();
	}
	
	public void setSelectedOrderNumber(String selectedOrder) {
		this.selectedOrderNumber = Integer.parseInt(selectedOrder.split("#")[1]);
		
	}
	
	public int getSelectedOrderNumber() {
		return selectedOrderNumber;
	}
	
	

	private void populateList()
	{
		try
	{
		 PreparedStatement psr = db.getConnection().prepareStatement("SELECT * FROM Restaurant");  
         ResultSet rsr = psr.executeQuery();  
           
         Restaurant rest;  
         while(rsr.next()) {  
             
                
              rest = new Restaurant(rsr.getInt("RestaurantID"),  
                                         rsr.getString("RestaurantUserName"),  
                                         rsr.getString("RestaurantPassword"),  
                                         rsr.getString("RestaurantName"),
                                         rsr.getString("RestaurantAdress"),
                                         rsr.getString("RestaurantContact"),
                                         rsr.getInt("RestaurantWorksFrom"),
                                         rsr.getInt("RestaurantWorksTo"));  
                
              restaurantList.add(rest);  
       }  
           
    } catch (SQLException e) {  
         // TODO Auto-generated catch block  
         e.printStackTrace();  
    }  
	}
	
	
	public DefaultListModel getRestaurantsForCustomerUI()
	{
		
		DefaultListModel listModelRestaurants = new DefaultListModel();
		
		for (Restaurant restaurant : restaurantList)
		{
			
			listModelRestaurants.addElement(restaurant.getRestaurantName() + "-Adress: " + restaurant.getRestaurantAdress());
		}
		
		return listModelRestaurants;
		
	}
	
	public void OpenDialog(JTable table, String extension)
	{
		JFileChooser fchoose = new JFileChooser();
        int option = fchoose.showSaveDialog(new JFrame());
        if(option == JFileChooser.APPROVE_OPTION){
          String name = fchoose.getSelectedFile().getName(); 
          String path = fchoose.getSelectedFile().getParentFile().getPath();
          String file = path + "\\" + name + "." + extension; 
          write(table, new File(file));
        }
        
	}
	
	public void write(JTable table, File file)
	{
		
		    try
		    {
		      TableModel m = table.getModel();
		      FileWriter fw = new FileWriter(file);
		      
		      for(int i = 0; i < m.getColumnCount(); i++){
		        fw.write(m.getColumnName(i) + "\t");
		      }
		      fw.write("\n");
		      for(int i=0; i < m.getRowCount(); i++) {
		        for(int j=0; j < m.getColumnCount(); j++) {
		          fw.write(m.getValueAt(i,j).toString()+"\t");
		        }
		        fw.write("\n");
		      }
		      fw.close();
		    }
		    catch(IOException e){ 
		    	
		    	System.out.println(e); }
}
	
	
	
	
	
	public ArrayList<Restaurant> getRestaurantList() {
		return restaurantList;
	}

	public void setRestaurantList(ArrayList<Restaurant> restaurantList) {
		this.restaurantList = restaurantList;
	}

}
