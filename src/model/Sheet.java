package model;


import java.util.HashMap;
import java.util.Map;
import java.util.Observable;


public class Sheet extends Observable implements Environment {

	private Map<String, Slot> map;
	private static SlotFactory factory;

	public Sheet(int rows, int columns) {
		map = new HashMap<String, Slot>();
		// for (int row = 1; row <= rows; row++) { bort
		// for (char ch = 'A'; ch < 'A' + columns; ch++) {
		// String key = Character.toString(ch) + Integer.toString(row);
		// map.put(key, new BlankSlot());
		// }
		// }
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

	// iterera HashMap fšr att sedan skicka en ny HashMap med String key samt
	// String value.Denna tas sedan emot och hanteras av SlotLabels,
	// dŠr vi fyller rutorna som finns i hashmapen och tšmmer de som inte finns
	public HashMap<String, String> getSlotList() {
		HashMap<String, String> list = new HashMap<String, String>();
		for (Map.Entry<String, Slot> entry : map.entrySet()) {
			list.put(entry.getKey(), String.valueOf(entry.getValue().value()));
		}
		return list;

	}

	@Override
	public Slot getSlot(String key) {
		return map.get(key);
	}
}
