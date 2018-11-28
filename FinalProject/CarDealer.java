package finalProject;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.awt.*;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.Border;
//import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import java.awt.event.*;



public class CarDealer extends JFrame implements TableModelListener, TableCellRenderer, ActionListener{
	int fullW = 1080;
	int fullH = 720;
	int leftPWidth = 540;
	int leftPHeight = 720;
	int carTableW = 540;
	int carTableH = 300;
	private List<Car> selectedCars = new ArrayList<Car>();
	private List<Car> carOnSale = new ArrayList<Car>();
	private Map<String, Integer> carInfo = new HashMap<String, Integer>(); 

	DefaultTableCellRenderer renderer;
	//*** left panel
	JPanel leftP = new JPanel();
	JCheckBox packageA = new JCheckBox("PackageA  $2200");
	JCheckBox packageB = new JCheckBox("PackageB  $3250");
	JCheckBox mPaint = new JCheckBox("Metallic Paint $650");
	JCheckBox tradeIn = new JCheckBox("Trade In");	
	JCheckBox cash = new JCheckBox("Pay Cash");
	JButton exit = new JButton("Exit");
	
	
	//*** right panel
	JPanel rightP = new JPanel();
	JLabel nameLabel;
	JLabel phoneLabel;
	JLabel taxLabel;
	JLabel totalLabel;

	public CarDealer() {
		/*
		 * Main window GUI components
		 * 1. left panel
		 * 		1-1 car model table
		 * 		1-2 available package check box
		 * 		1-3 payment type check box
		 * 		1-4 trade-in check box
		 * 2. right panel (summary)
		 */
		
		//main window properties
		this.setTitle("Car Dealer");
		this.setSize(fullW, fullH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setLayout(new GridLayout(1, 2));
		
		//*********** left panel **************
		leftP.setBackground(Color.LIGHT_GRAY);
		//leftP.setSize(leftPWidth, leftPHeight);
		
		//create car model table
		
		JTable t = new JTable(new CarTableModel());
		
		//allow multiple rows selection
		t.setRowSelectionAllowed(true);		
		t.setColumnSelectionAllowed(false);
		t.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION) ;
		t.getModel().addTableModelListener(this);
				
		//center the header and the text in the table		
		DefaultTableCellRenderer centerText = new DefaultTableCellRenderer();
		centerText.setHorizontalAlignment(JLabel.CENTER);
		t.setDefaultRenderer(String.class, centerText);
		renderer = (DefaultTableCellRenderer)t.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		
		//package section
		JPanel packageP = new JPanel();
		packageA.setVisible(true);
		if(true) {
			packageB.setVisible(true);
		}
		else {
			packageB.setVisible(false);
		}
		packageP.add(packageA);
		packageP.add(packageB);
		packageP.add(mPaint);
		
		
		
		JPanel carP = new JPanel(new GridLayout(2,1));
		JScrollPane carTablePanel = new JScrollPane(t);
		carTablePanel.setBorder(BorderFactory.createEmptyBorder());
		carP.add(carTablePanel);	
		carP.add(packageP);
		packageP.setVisible(true);
		//check box group
		JPanel checkboxP = new JPanel();
		checkboxP.add(tradeIn);
		checkboxP.add(cash);
		
		tradeIn.addActionListener(this);
		cash.addActionListener(this);
		
		//exit button
		JPanel exitP = new JPanel();
		exitP.add(exit);
				
		JPanel leftP = new JPanel();		
		leftP.setVisible(true);
		leftP.setLayout(new GridLayout(3,1));
		leftP.add(carP);
		leftP.add(checkboxP);
		leftP.add(exitP);
				
		JPanel rightP = new JPanel();
		//rightP.add(cash);
		rightP.setVisible(true);
		this.add(leftP);
		this.add(rightP);
		this.setVisible(true);
	
		
		//*********** end of GUI components ************
		
		
		
		
		//initiate Car objects with the info in the table
		carInfo = this.getCarInfo();
		
		for(Map.Entry<String, Integer> car : carInfo.entrySet()) {
			Car newCar = new Car(car.getKey(), car.getValue());
			System.out.println(car.getKey() + car.getValue());
			carOnSale.add(newCar);
		}
		System.out.println(carOnSale.get(1).getModel());		
	}

//******************  table related class and methods  ****************** 
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
				}				
			}
		}
		else {
			for(Car eachModel : carOnSale) {
				if(eachModel.getModel() == selectedModel) {
					selectedCars.remove(eachModel);
				}				
			}
		}

	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		 
		return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}


//******************  end of table related class and methods  ****************** 
 
//******************  check boxes related class and methods  ****************** 
	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox selection = (JCheckBox)e.getSource();
		System.out.println(e.getActionCommand());
		System.out.println("selection" + selection);
		
	}

//******************  end of check boxes related class and methods  ******************	
//****************** Get carInfo from CarTableModel ****************** 

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
	
	

	public static void main(String[] args){
		CarDealer window1 = new CarDealer();
	}


	
}
