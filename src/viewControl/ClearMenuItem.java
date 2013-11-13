package viewControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import model.Sheet;
import model.XLException;

class ClearMenuItem extends JMenuItem implements ActionListener {
	private Sheet sheet;
	private CurrentModel currentModel;

	public ClearMenuItem(Sheet sheet, CurrentModel currentModel) {
		super("Clear");
		this.sheet = sheet;
		this.currentModel = currentModel;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String key = currentModel.getCurrent().toString();
		try{
		sheet.removeSlot(key);
		}
		catch (XLException xle){
			currentModel.setErrorMessage(xle.getMessage());
		}
	}
}
