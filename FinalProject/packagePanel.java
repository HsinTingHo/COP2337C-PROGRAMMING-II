package finalProject;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class packagePanel extends JPanel{
	public JCheckBox pgA = new JCheckBox("Package A        $2200");
	public JCheckBox pgB = new JCheckBox("Package B        $3250");
	public JCheckBox metallicP = new JCheckBox("Metallic paint   $650");
	private Map<String, Integer> selectedPackage = new HashMap<String, Integer>();
	private int PACKAGE_A = 2200;
	private int PACKAGE_B = 3250;
	private int METALLIC_PAINT = 650;
	
	public packagePanel() {
		this.setLayout(new GridLayout(3, 1));
		add(pgA);
		pgB.setEnabled(false);;
		add(pgB);
		add(metallicP);
		setBorder(BorderFactory.createTitledBorder("Packages"));
		this.setVisible(true);
	}
	
	public int getPackagePrice() {
		int packagePrice = 0;
		if(pgA.isSelected()) {
			packagePrice += PACKAGE_A;
			selectedPackage.put("Package      A", 2200);
		}
		if(pgB.isSelected()) {
			packagePrice += PACKAGE_B;
			selectedPackage.put("Package      B", 3250);
		}
		if(metallicP.isSelected()) {
			packagePrice += METALLIC_PAINT;
			selectedPackage.put("Metallic Paint", 650);
		}
		
		return packagePrice;
	}
	
	public Map<String, Integer> getSelectedPg(){
		return selectedPackage;
	}
}
