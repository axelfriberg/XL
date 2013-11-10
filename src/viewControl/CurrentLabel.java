package viewControl;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;

@SuppressWarnings("serial")
public class CurrentLabel extends ColoredLabel implements Observer {
	private CurrentModel currentModel;

	public CurrentLabel(CurrentModel currentModel) {
		super("A1", Color.WHITE);
		this.currentModel = currentModel;
		currentModel.addObserver(this);

	}

	public void update(Observable obs, Object obj) {
		String current = currentModel.getCurrent().toString();
		setText(current);
	}

}