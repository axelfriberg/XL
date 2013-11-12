package model;

import util.XLException;

public class ArmedBomb implements Bomb{


	public void detonate() {
		throw new XLException("Circular dependency.");
	}

}
