package viewControl;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.Sheet;

public class Editor extends JTextField implements KeyListener, Observer {
	private Sheet sheet;
	private CurrentModel currentModel;

	public Editor(Sheet sheet, CurrentModel currentModel) {
		this.sheet = sheet;
		this.currentModel = currentModel;
		setBackground(Color.WHITE);
		addKeyListener(this);
		currentModel.addObserver(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			String s = getText();
			try {
				sheet.addSlot(currentModel.getCurrent().toString(), s);
				currentModel.setErrorMessage("");
			} catch (Exception e) {
				currentModel.setErrorMessage(e.getMessage());
				setText(currentModel.getCurrent().toString());
			}

		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		String address = currentModel.getCurrent().toString();
		String text = currentModel.getCurrent().getText();
		if (text.equals("                    ")) {
			setText("");
		} else {
			setText(sheet.getSlot(address).toString());

		}
	}
}