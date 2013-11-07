package viewControl;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;

@SuppressWarnings("serial")
public class CurrentLabel extends ColoredLabel implements Observer {
	private Sheet sheet;
	public CurrentLabel(Sheet sheet) {
		super("A1", Color.WHITE);
		this.sheet = sheet;
		sheet.addObserver(this);
	}

	public void update(Observable obs, Object obj) {
		setText(sheet.getCurrentLocation());
	}

}