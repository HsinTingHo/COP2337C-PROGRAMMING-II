package finalProject;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExitWindow extends JFrame{
	public ExitWindow() {
		setLayout(new GridLayout(2, 1));
		setSize(300, 150);
		JLabel msg = new JLabel("All the data will be lost after Exit. Are you sure?");
		JButton exit = new JButton("Exit");
		
		JPanel bP = new JPanel();
		bP.add(exit);
		exit.addActionListener(new ExitButton());
		add(msg);
		add(bP);
		setVisible(true);
	}
	private class ExitButton implements ActionListener{
		

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(DO_NOTHING_ON_CLOSE);
			
		}
		
	}
}
