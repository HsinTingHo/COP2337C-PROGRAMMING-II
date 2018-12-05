package finalProject;

import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


//This class is used to implement customer fields, methods and interactions //


public class CustomerWindow extends JFrame {
	
	private JPanel customerPanel, nameP, phoneP, addP, addP2; 						//label for screen
	private JLabel messageLabel, nameLabel, phoneLabel, addLabel, cityLabel, stateLabel, zipLabel; 				// message that instructs user
	//private JTextField accountNumTextField;		//text field for account number
	private JTextField nameTextField, phoneTextField, addressTextField, cityTextField, zipTextField;			//text field for name
	private JComboBox stateMenu;
	private JLabel messageSummary;				//account summary message
	private JButton enter = new JButton("Enter");
	private String states = "Alabama Alaska Arizona Arkansas California Colorado Connecticut Delaware Florida Georgia Hawaii Idaho Illinois Indiana Iowa Kansas Kentucky Louisiana Maine Maryland Massachusetts Michigan Minnesota Mississippi Missouri Montana Nebraska Nevada New Hampshire New Jersey New Mexico New York North Carolina North Dakota Ohio Oklahoma Oregon Pennsylvania Rhode Island South Carolina South Dakota Tennessee Texas Utah Vermont Virginia Washington West Virginia Wisconsin Wyoming";
	private String[] statesArray = states.split(" ");
	int WINDOW_WIDTH = 500;
	int WINDOW_HEIGHT = 300;
	
	int accountNumandomR; //To hold random number
//Constuctor
	public CustomerWindow()
	{
	this.setTitle("Customer Info"); 					//Window title
	this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);			//sets size of window
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//exits when close button is selected.
	setLocationRelativeTo(null);
	//this.setLayout();					//creates Borderlayout
	buildCustomerPanel();									//builds panel and add it to the frame

	this.setVisible(true);
	}
	
	private void buildCustomerPanel()
	{
		
		customerPanel = new JPanel(new GridLayout(4, 1));
		nameP = new JPanel();
		nameLabel = new JLabel("Name:");
		nameTextField = new JTextField(15);
		nameP.add(nameLabel);
		nameP.add(nameTextField);
		phoneLabel = new JLabel("Phone:");
		phoneTextField = new JTextField(15);
		nameP.add(phoneLabel);
		nameP.add(phoneTextField);
		
		addP = new JPanel();
		addLabel = new JLabel("Street:");
		addressTextField = new JTextField(34);
		addP.add(addLabel);
		addP.add(addressTextField);
		
		addP2 = new JPanel();
		cityLabel = new JLabel("City:");
		cityTextField = new JTextField(10);
		stateLabel = new JLabel("State:");
		stateMenu = new JComboBox(statesArray);
		zipLabel = new JLabel("Zip:");
		zipTextField = new JTextField(5);
		addP2.add(cityLabel);
		addP2.add(cityTextField);
		addP2.add(stateLabel);
		addP2.add(stateMenu);
		addP2.add(zipLabel);
		addP2.add(zipTextField);
		

		customerPanel.add(nameP);
		customerPanel.add(addP);
		customerPanel.add(addP2);
		enter.addActionListener(new EnterInfo());
		customerPanel.add(enter);

		this.add(customerPanel);
	}
	
	private class EnterInfo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int stateIndex = stateMenu.getSelectedIndex();
			String s = statesArray[stateIndex];
			String name = nameTextField.getText();
			String address = addressTextField.getText() + "\n"+cityTextField.getText()+", "+ s +" "+zipTextField.getText();
			String phone = phoneTextField.getText();
			if(name.isEmpty() || phone.isEmpty() || addressTextField.getText().isEmpty() || zipTextField.getText().isEmpty()) {
				System.out.println(name);
				JOptionPane.showMessageDialog(null, "Please make sure to complete all the fields.");
			
			}
			else{
				
				Customer c1 = new Customer(name, address, phone);
				CarDealer window1 = new CarDealer(c1);
			}
		}
		
	}
	public static void main(String[] args){
		CustomerWindow c = new CustomerWindow();		
	}
}

