package model;


public class BombSlot implements Slot{

	public double value() {
		throw new XLException("Circular dependency.");
	}

	public String output() {
		throw new XLException("Circular dependency.");
	}
}
