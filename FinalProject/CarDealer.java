package finalProject;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;
import java.lang.Math;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
//import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


import java.awt.event.*;



public class CarDealer extends JFrame{
	private ArrayList<Car> carOnSale = new ArrayList<Car>();
	private ArrayList<Car> selectedCars = new ArrayList<Car>();
	private Map<String, Integer> carInfo = new HashMap<String, Integer>();
	private packagePanel pp = new packagePanel();
	private tradeInPanel tp = new tradeInPanel();
	private financialPanel fp = new financialPanel();
	private JPanel up, down;
	private Customer customer;
	public CarDealer(Customer c) {
			this.customer = c;
			System.out.println(c.getAccNum());
	        // Display a title.
	        setTitle("Car Dealer");
	        setSize(720, 500);
	        // Specify an action for the close button.
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        // Create a BorderLayout manager.
	        setLayout(new BorderLayout());
	        setLocationRelativeTo(null);
	        JTable t = new JTable(new CarTableModel());			
		    //allow multiple rows selection
		    t.setRowSelectionAllowed(true);		
		    t.setColumnSelectionAllowed(false);
		    t.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION) ;
		    t.getModel().addTableModelListener(new TableAction());
					
			//center the header and the text in the table
			DefaultTableCellRenderer renderer;
			DefaultTableCellRenderer centerText = new DefaultTableCellRenderer();
			centerText.setHorizontalAlignment(JLabel.CENTER);
			t.setDefaultRenderer(String.class, centerText);
			renderer = (DefaultTableCellRenderer)t.getTableHeader().getDefaultRenderer();
			renderer.setHorizontalAlignment(JLabel.CENTER);
			JScrollPane carTablePanel = new JScrollPane(t);
			carTablePanel.setPreferredSize(new Dimension(718, 100));
			carTablePanel.setVisible(true);
			
			
			this.carInfo = getCarInfo();
			for(Map.Entry<String, Integer> car : carInfo.entrySet()) {
				Car newCar = new Car(car.getKey(), car.getValue());
				System.out.println(car.getKey() + car.getValue());
				carOnSale.add(newCar);
			}
			
	        
	        
	        up = new JPanel(new GridLayout(2,1));	        
	        up.add(builtCustomerPanel(c));
	        up.add(carTablePanel);
					
			add(up, BorderLayout.NORTH);
			add(pp, BorderLayout.WEST);
			add(tp, BorderLayout.CENTER);
			add(fp, BorderLayout.EAST);
			add(buitButtonPanel(), BorderLayout.SOUTH);
			
			
	        setVisible(true);
	      
	}
	

	
	private Map<String, Integer> getCarInfo() {
		int num;
		Map<String, Integer> carInfo = new HashMap<String, Integer>();
		CarTableModel cInfo = new CarTableModel();
		num = cInfo.getRowCount();
		for(int count = 0; count < num; count++) {
			Integer price = Integer.valueOf(cInfo.getValueAt(count, 1).toString().replace("$", ""));
			carInfo.put(cInfo.getValueAt(count, 0).toString(), price);
		}
		return carInfo;
	}
	
	private JPanel buitButtonPanel() {
		JPanel buttonP = new JPanel();
		JButton calculate = new JButton("Show Price");
		JButton exit = new JButton("Exit");
		
		calculate.addActionListener(new CalcButtonListener());
		exit.addActionListener(new ExitButton());
		buttonP.add(calculate);
		buttonP.add(exit);
		
		return buttonP;
	}
	
	private JPanel builtCustomerPanel(Customer c) {
		JPanel customerP = new JPanel(new GridLayout(4, 1));
		JLabel name = new JLabel("Name: "+ c.getName());
		name.setForeground(Color.BLUE);
		JLabel add = new JLabel("Address: "+ c.getAdd());
		add.setForeground(Color.BLUE);
		JLabel phone = new JLabel("Phone: "+ c.getPhone());
		phone.setForeground(Color.BLUE);
		JLabel acc = new JLabel("Account#: "+ c.getAccNum());
		acc.setForeground(Color.BLUE);
		customerP.add(name);
		customerP.add(add);
		customerP.add(phone);
		customerP.add(acc);
		customerP.setVisible(true);
		return customerP;
		
	}
	
	private class TableAction implements TableModelListener {
		
		@Override
		public void tableChanged(TableModelEvent e) {
			int row = e.getFirstRow();//get the first row that changed
			int column = e.getColumn();//returns the column for the event
			String selectedModel;
			TableModel model = (TableModel)e.getSource();
			boolean checked = (boolean)model.getValueAt(row, column);
			selectedModel = (String) model.getValueAt(row, 0);
			
			//if the check box is selected, add the item to the selectedCar list
			if(checked) {						
				for(Car eachModel : carOnSale) {
					if(eachModel.getModel() == selectedModel) {
						selectedCars.add(eachModel);
						if(selectedModel == "S70" || selectedModel == "S80") {
							pp.pgB.setEnabled(true);
						}
					}				
				}
			}
			else {
				for(Car eachModel : carOnSale) {
					if(eachModel.getModel() == selectedModel) {
						selectedCars.remove(eachModel);
						pp.pgB.setEnabled(false);
					}				
				}
			}			
		}					
	}
	
	private class CalcButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			final int TAGS = 325;
			double sumCarPrice = 0, sumPgPrice = 0, tradeInDiscount = 0, subTotal = 0, financePrice = 0;
			String summary = "";
			for(Car each : selectedCars) {
				sumCarPrice += each.getPrice();
			}
			sumPgPrice = pp.getPackagePrice();
			tradeInDiscount = tp.getTradeInDiscount();
			subTotal = TAGS + sumCarPrice + sumPgPrice - tradeInDiscount;
			financePrice = fp.getFinance(subTotal);
			summary = getSummary();
			System.out.println("Subtotal: "+ (financePrice));
			if(summary != null) {
				JOptionPane.showMessageDialog(null, summary);
			}
			
			
		}		
	}
	private class ExitButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ExitWindow exitW = new ExitWindow();
			
		}
		
	}
	private String getSummary() {
		boolean proceed = true;
		String summary = "";
		String car = "", pg = "", ti = "", subtotal = "", tax = "", total = "", line = "_______________________";
		double sum = 0, calc = 0;
		Map<String, Integer> pgs = pp.getSelectedPg();
		String[] tis = tp.getTradeIn(); 
		car += "Orders:\n";
		//if no car is selected, throw error window
		if(selectedCars.size()>0) {
			for(Car each : selectedCars) {
				car += each.getModel() + "                   $" + each.getPrice()+"\n";								 
				sum += each.getPrice(); 
			}
			car += "Tags                  $"+ (325 * selectedCars.size())+"\n";
			sum += 325 * selectedCars.size();
		}
		else {
			JOptionPane.showMessageDialog(null, "You forgot to select a car model.");
			proceed = false;
		}
		if(proceed) {
			pg+= "\nPackages:\n";
			for(Entry<String, Integer> pg1 : pgs.entrySet()) {
				pg += pg1.getKey() + "    $" + pg1.getValue()+"\n";
				sum += pg1.getValue();
			}
			ti+= "\nTrade In:\n";
			try {		
				ti += tis[0]+"                 -$"+tis[1]+"\n";
				sum -= Integer.valueOf(tis[1]);
			}
			catch(Exception e) {
				System.out.println("No trade In");
				ti += "TradeIn Disc.   -$"+0+"\n";
			}
						
			calc = fp.getFinance(sum);
			if(sum - fp.getFinance(sum) == 750) {		
				subtotal += "\nCash Disc.      -$" + 750+"\n";
				subtotal += "Subtotal             $" + calc +"\n";
				subtotal += line;
			}
			else {
				subtotal += line;
				subtotal += "\n7% Finance Applied\n";
				subtotal += "Monthly Payment$" + Math.round(calc) +"\n";			
			}
			tax +="\nTax(6%)              $"+ Math.round((calc*0.06))+"\n";
			total += "Total                  $"+Math.round((calc*1.06));
			summary = car + pg + ti + subtotal+ tax +total;						
		}
		else {
			summary = null;
		}
		return summary;
	}


/*
	public static void main(String[] args){
		CustomerWindow cInfo = new CustomerWindow();
		CarDealer window1 = new CarDealer();
	}
*/	

}
