package finalProject;
import java.awt.*;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class CarTableModel extends AbstractTableModel{
	String[] columns = {"Model", "Base Price", "Select"};
	Object[][] tcontents = {
		{"S40", "$27700", false},
		{"S60", "$32500", false},
		{"S70", "$36000", false},
		{"S80", "$44000", false}			
	};

	@Override
	public int getRowCount() {
		return tcontents.length;
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}
	
	@Override
	public String getColumnName(int col) {
		return columns[col].toString();
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return tcontents[rowIndex][columnIndex];
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if(columnIndex == 2) {
			if(aValue instanceof Boolean) {
				tcontents[rowIndex][columnIndex] = (Boolean)aValue;
				fireTableCellUpdated(rowIndex, columnIndex);
			}
		}
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		if(col < 2) {
			return false;
		}
		else {
			return true;
		}
	}
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}


	
}
