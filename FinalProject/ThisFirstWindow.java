import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ThisFirstWindow extends JFrame{

	private final int WIDTH=500;
	private final int HEIGHT=400;
	private final int XLoc=500;
	private final int YLoc=500;
	private JLabel userInputLabel;
	private JTextField userInputTextField;
	private JButton calculate;
	private JPanel panel;
	
	public ThisFirstWindow() {
		this.setTitle("First Window Extended");
		this.setSize(WIDTH,HEIGHT);
		this.setLocation(XLoc,YLoc);
		userInputLabel = new JLabel("Enter distance in Kilometers: ");
		userInputTextField=new JTextField(10);
		calculate=new JButton("Calculate");
		calculate.addActionListener(new ButtonListener());
		panel=new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(userInputLabel);
		panel.add(userInputTextField);
		panel.add(calculate);
		add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			double miles=0.62*Double.parseDouble(userInputTextField.getText());
			JOptionPane.showMessageDialog(null, miles+" miles ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThisFirstWindow myWindow=new ThisFirstWindow();
		

	}

}
