package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Sheet extends Observable implements Environment {

	private Map<String, Slot> map;
	private static SlotFactory factory;
	private String currentSlot;

	public Sheet(int rows, int columns) {
		map = new HashMap<String, Slot>();
		for (int row = 1; row <= rows; row++) {
			for (char ch = 'A'; ch < 'A' + columns; ch++) {
				String key = Character.toString(ch) + Integer.toString(row);
				map.put(key, new BlankSlot());
			}
		}
		factory = new SlotFactory(this);
		currentSlot = "A1";

	}

	public double value(String key) {
		return map.get(key).value();
	}

	public void addSlot(String argument) {
		map.remove(currentSlot);
		map.put(currentSlot, factory.createSlot(argument));
		setChanged();
		notifyObservers();

	}

	public void updateCurrent(String key) {
		currentSlot = key;
		setChanged();
		notifyObservers();
	}

	public String getCurrentLocation() {
		return currentSlot;
	}

	public Slot getSlot(String key) {
		return map.get(key);
	}

}
