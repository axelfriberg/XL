package viewControl;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;

@SuppressWarnings("serial")
public class StatusLabel extends ColoredLabel implements Observer {
	private Sheet sheet;

	public StatusLabel(Sheet sheet) {
		super("", Color.WHITE);
		setForeground(Color.RED);
		this.sheet = sheet;
		sheet.addObserver(this);
	}

	public void update(Observable observable, Object object) {
		setText(sheet.getException());
	}
}