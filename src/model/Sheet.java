package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;

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

	public ArrayList<String> getSlotList() {
		ArrayList<Slot> slotList = (ArrayList<Slot>) map.values();
		ArrayList<String> slots = new ArrayList<String>();
		for (Slot s : slotList) {
			slots.add(s.toString());
		}
		return slots;

	}

	@Override
	public Slot getSlot(String key) {
		return map.get(key);
	}
}
