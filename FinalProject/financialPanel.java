package finalProject;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class financialPanel extends JPanel {
	private JCheckBox cash = new JCheckBox("Pay Cash");
	private JCheckBox financial = new JCheckBox("3 Year-Finance (7%)");
	private static final double FINANCE = 0.07;
	public financialPanel(){
		setLayout(new GridLayout(2, 1));
		setBorder(BorderFactory.createTitledBorder("Finance"));
		ButtonGroup group = new ButtonGroup();
		group.add(cash);
		group.add(financial);
		add(cash);
		add(financial);
		setVisible(true);
	}
	
	public double getFinance(double total) {
		double price = 0;
		if(cash.isSelected()) {
			price = total -750;
		}
		else {
			price = total*(1+ FINANCE*36)/36;
		}
		System.out.println("getFinance: "+ price);
		return price;
	}
}
