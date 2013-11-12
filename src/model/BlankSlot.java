package model;

import util.XLException;

public class BlankSlot implements Slot{
	
	public BlankSlot(){
		
	}

	public double value() {
		throw new XLException("Obefintligt värde!");
	}
	
	public String toString(){
		return "";
	}
	
	public String output(){
		throw new XLException("Obefintligt värde!");
	}
	
}
