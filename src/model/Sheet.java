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
			throw e;
		}
	}

	public void addSlot(String key, String argument) {
		Slot temp = getSlot(key);
		map.put(key, new BombSlot());
		try {
			map.put(key, factory.createSlot(argument));
		} catch (XLException e) {
			if (!(temp.getClass().equals(BlankSlot.class))) {
				map.put(key, temp);
			} else {
				map.remove(key);
			}
			throw e;
		}
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
		Slot temp = getSlot(key);
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
			br.load(this);
			setChanged();
			notifyObservers();
		} catch (Exception e) {
			throw new XLException(e.getMessage());
		}

	}
}
