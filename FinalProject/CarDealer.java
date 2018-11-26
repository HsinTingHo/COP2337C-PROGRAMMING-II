package finalProject;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.event.*;
import java.awt.event.ActionListener;



public class CarDealer extends JFrame implements TableModelListener{
	int fullW = 1080;
	int fullH = 720;
	private List<Car> selectedCars = new ArrayList<Car>();
	private List<Car> carOnSale = new ArrayList<Car>();
	private Map<String, Integer> carInfo = new HashMap<String, Integer>(); 
	JLabel label;
	JTextField tField;
	
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
		
		//initiate Car objects with the info in the table
		carInfo = this.getCarInfo();
		
		for(Map.Entry<String, Integer> car : carInfo.entrySet()) {
			Car newCar = new Car(car.getKey(), car.getValue());
			carOnSale.add(newCar);
		}
		System.out.println(carOnSale);		
	}
/*
 * Main window GUI components
 * 1. left panel
 * 		1-1 car model table
 * 		1-2 available package check box
 * 		1-3 payment type check box
 * 		1-4 trade-in check box
 * 2. right panel (summary)
 */
	//make left panel
	public JPanel leftPanel() {
		int width = 540;
		int height = 360;	
		
		leftP.setBackground(Color.LIGHT_GRAY);
		leftP.setSize(width, height);
		

		JTable t = new JTable(new CarTableModel());
		//center the text in the table		
		DefaultTableCellRenderer centerText = new DefaultTableCellRenderer();
		centerText.setHorizontalAlignment(JLabel.CENTER);
		t.setDefaultRenderer(String.class, centerText);
		//allow mutable rows selection
		t.setRowSelectionAllowed(true);		
		t.setColumnSelectionAllowed(false);
		t.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION) ;
		t.getModel().addTableModelListener(this);
		//add table to JScrollPane so the header does not get cut off
		leftP.add(new JScrollPane(t));
		leftP.setVisible(true);

		return leftP;
	}
/*
 * End of GUI components
 */
	
	
/*
 * Get carInfo from CarTableModel
 */
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
	
	
	
	private class buttonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String customer = tField.getText();
			JOptionPane.showMessageDialog(null, "Name: "+customer);
			
		}
		
	}
	public static void main(String[] args){
		CarDealer window1 = new CarDealer();
	}
	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();//get the first row that changed
		int column = e.getColumn();//returns the column for the event
		TableModel model = (TableModel)e.getSource();
		Object data = model.getValueAt(row, column);
		System.out.println(data);
	}
}
