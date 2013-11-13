package viewControl;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;

@SuppressWarnings("serial")
public class StatusLabel extends ColoredLabel implements Observer {
	private CurrentModel model;

	public StatusLabel(CurrentModel model) {
		super("", Color.WHITE);
		setForeground(Color.RED);
		this.model = model;
		model.addObserver(this);
	}

	public void update(Observable observable, Object object) {
		setText(model.getExceptionMessage());
	}
}