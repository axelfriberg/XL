package model;

import util.XLException;

public class BlankSlot implements Slot{
	
	public BlankSlot(){
		
	}

	public double value() {
		throw new XLException("Empty slot referal.");
	}
	
	public String toString(){
		return "";
	}
	
	public String output(){
		throw new XLException("Empty slot referal.");
	}
	
}
