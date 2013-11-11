package model;


import java.util.HashMap;
import java.util.Map;
import java.util.Observable;


public class Sheet extends Observable implements Environment {

	private Map<String, Slot> map;
	private static SlotFactory factory;

	public Sheet(int rows, int columns) {
		map = new HashMap<String, Slot>();
		factory = new SlotFactory(this);

	}

	public double value(String key) {
		return map.get(key).value();
		
	}

	public void addSlot(String key, String argument) {
		Slot current = factory.createSlot(argument);
		map.remove(key);
		map.put(key, current);
		setChanged();
		notifyObservers();

	}

	public HashMap<String, String> getSlotMap() {
		HashMap<String, String> stringMap = new HashMap<String, String>();
		for (Map.Entry<String, Slot> entry : map.entrySet()) {
			stringMap.put(entry.getKey(), entry.getValue().output());
		}
		return stringMap;

	}

	@Override
	public Slot getSlot(String key) {
		return map.get(key);
	}
}
