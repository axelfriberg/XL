package model;

import java.io.FileNotFoundException;
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

public class Sheet extends Observable implements Environment {

	private Map<String, Slot> map;
	private static SlotFactory factory;

	public Sheet(int rows, int columns) {
		map = new HashMap<String, Slot>();
		factory = new SlotFactory(this);

	}

	public double value(String key) {
		try {
			return getSlot(key).value();
		} catch (XLException e) {
			System.out.println("Sheet.value()");
			throw e;
		}
	}

	public void addSlot(String key, String argument) {
		Slot current;
		boolean go = true;
		try {
			current = factory.createSlot(argument);
		} catch (Exception e) {
			System.out.println("RÄTT STÄLLE!");
			throw new XLException(e.getMessage());
		}
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
		if (map.get(key) != null) {
			return map.get(key);
		}

		return new BlankSlot();

	}

	public void resetMap() {
		map = new HashMap<String, Slot>();
		setChanged();
		notifyObservers();
	}

	public void removeSlot(String key) {
		Slot temp = map.get(key);
		map.remove(key);
		try {
			for (Map.Entry<String, Slot> entry : map.entrySet()) {
				entry.getValue().value();
			}
		} catch (XLException e) {
			map.put(key, temp);
			throw new XLException("Can not remove slot, global dependency.");
		}
		setChanged();
		notifyObservers();
	}

	public void save(String fileName) {
		try {
			XLPrintStream ps = new XLPrintStream(fileName);
			ps.save(map.entrySet());

		} catch (FileNotFoundException e) {
			throw new XLException(e.getMessage());
		}

	}

	public void load(String fileName) {
		try {
			resetMap();
			XLBufferedReader br = new XLBufferedReader(fileName);
			br.load(map, factory);
			setChanged();
			notifyObservers();
		} catch (FileNotFoundException e) {
			throw new XLException(e.getMessage());
		}

	}
}
