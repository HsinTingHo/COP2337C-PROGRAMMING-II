package finalProject;
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarDealer extends JFrame{
	int fullW = 1080;
	int fullH = 720;
	JLabel label;
	JTextField tField;
	JButton s40, s60, s70, s80;
	JPanel leftP = new JPanel();
	
	public CarDealer() {
		//Declaring components on the main window
		leftP = leftPanel();
		
		//main window properties
		this.setTitle("Car Dealer");
		this.setSize(fullW, fullH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setLayout(new BorderLayout());		
		this.add(leftP, BorderLayout.WEST);
		this.setVisible(true);
		
		
		
	}
	
	//make left panel
	public JPanel leftPanel() {
		int width = 540;
		int height = 360;	
		leftP.setBackground(Color.LIGHT_GRAY);
		leftP.setSize(width, height);
		
		s40 = new JButton("S40");
		s60 = new JButton("S60");
		s70 = new JButton("S70");
		s80 = new JButton("S80");
		//button.addActionListener(new buttonActionListener());
		
		leftP.add(s40);
		leftP.add(s60);
		leftP.add(s70);
		leftP.add(s80);
		leftP.setVisible(true);
		return leftP;
	}
	
	private class buttonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String customer = tField.getText();
			JOptionPane.showMessageDialog(null, "Name: "+customer);
			//practice
			//double km = Double.parseDouble(tField.getText());
			//System.out.print(km/1.6);
		}
		
	}
	public static void main(String[] args){
		CarDealer window1 = new CarDealer();
	}
}
