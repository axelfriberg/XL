package model;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import util.XLException;

public class Sheet extends Observable implements Environment {

	private Map<String, Slot> map;
	private static SlotFactory factory;
	private String errorMsg = "";

	public Sheet(int rows, int columns) {
		map = new HashMap<String, Slot>();
		factory = new SlotFactory(this);

	}

	public double value(String key) {
		try {
			return getSlot(key).value();
		} catch (Exception e) {
			errorMsg = e.getMessage();
			throw new XLException(e.getMessage());
		}
	}

	public String getException() {
		String temp = errorMsg;
		errorMsg = "";
		return temp;
	}

	public void addSlot(String key, String argument) {
		try {
			Slot current = factory.createSlot(argument);
			map.remove(key);
			map.put(key, current);
			setChanged();
			notifyObservers();
		} catch (Exception e) {
			errorMsg = e.getMessage();
			setChanged();
			notifyObservers();
		}

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
		map.remove(key);
		setChanged();
		notifyObservers();
	}

	public void save(String fileName) {
		try {
			XLPrintStream ps = new XLPrintStream(fileName);
			ps.save(map.entrySet());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void load(String fileName){
		try {
			XLBufferedReader br = new XLBufferedReader(fileName);
			br.load(map, factory);
			setChanged();
			notifyObservers();
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
