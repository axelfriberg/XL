package model;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import util.XLException;

public class ExprSlot extends Observable implements Slot, Observer {

	Environment env;
	Expr expr;
	String argument;
	ExprParser parser;

	public ExprSlot(String argument, Environment env) {
		this.env = env;
		this.argument = argument;
		parser = new ExprParser();
		try {
			 expr = parser.build(argument);
		} catch (IOException e) {
			throw new XLException("Felaktig inmatning!");
		}
		
		
	}

	public void update(Observable arg0, Object arg1) {

	}

	public double value() {
		return expr.value(env);
	}

	public String toString(){
		return expr.toString();
	}
}
