package finalProject;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class tradeInPanel extends JPanel{
	private JLabel intro = new JLabel();
	private JRadioButton s40 = new JRadioButton("S40");
	private JRadioButton s60 = new JRadioButton("S60");
	private JRadioButton s70 = new JRadioButton("S70");
	private JRadioButton s80 = new JRadioButton("S80");
	private String[] selectedM;
	private int S40, S60, S70, S80;
	public tradeInPanel() {
		String str = "Trade in will deduct half of the modle price.";
		setLayout(new GridLayout(5,1));
		intro.setText(str);
		add(intro);
		
		ButtonGroup group = new ButtonGroup();
		group.add(s40);
		group.add(s60);
		group.add(s70);
		group.add(s80);
		add(s40);
		add(s60);
		add(s70);
		add(s80);
		setBorder(BorderFactory.createTitledBorder("Trade-In"));
		setVisible(true);
		
		CarTableModel cInfo = new CarTableModel();
		S40 = Integer.valueOf(((String) cInfo.tcontents[0][1]).replace("$", ""))/2;
		S60 = Integer.valueOf(((String) cInfo.tcontents[1][1]).replace("$", ""))/2;
		S70 = Integer.valueOf(((String) cInfo.tcontents[2][1]).replace("$", ""))/2;
		S80 = Integer.valueOf(((String) cInfo.tcontents[3][1]).replace("$", ""))/2;
	}
	public int getTradeInDiscount() {
		int discount = 0;
		if(s40.isSelected()) {
			selectedM = new String[] {"S40", String.valueOf(S40)};
			
			discount +=  S40;
		}
		if(s60.isSelected()) {
			selectedM = new String[] {"S60", String.valueOf(S60)};
			
			discount +=  S60;
		}
		if(s70.isSelected()) {
			selectedM = new String[] {"S70", String.valueOf(S70)};
			
			discount +=  S70;
		}
		if(s80.isSelected()) {
			selectedM = new String[] {"S80", String.valueOf(S80)};
			
			discount +=  S80;
		}
		System.out.println("Trade In discount: "+ discount);
		return discount;
	}
	public String[] getTradeIn(){
		return selectedM;
	}
}
