package model;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import expr.Expr;
import expr.ExprParser;
import util.XLException;

public class ExprSlot extends Observable implements Slot, Observer {

	Environment env;
	Expr expr;
	String argument;
	ExprParser parser;
	Bomb bomb;

	public ExprSlot(String argument, Environment env) {
		this.env = env;
		this.argument = argument;
		bomb = new DisarmedBomb();
		parser = new ExprParser();
		try {
			expr = parser.build(argument);
		} catch (IOException e) {
			throw new XLException("Failed to build expression.");
		}
		try {
			expr.value(env);
		} catch (XLException e) {
			throw new XLException("Empty slot referal.");
		}

	}

	public void update(Observable arg0, Object arg1) {

	}

	public double value() {
		bomb.detonate();
		bomb = new ArmedBomb();
		try {
			double val = expr.value(env);
			bomb = new DisarmedBomb();
			return val;
		} catch (XLException e) {
			System.out.println(e.getMessage());
			throw new XLException(e.getMessage());
		}
	}

	public String toString() {
		return expr.toString();
	}

	public String output() {
		return String.valueOf(value());
	}

	public void bombType(Bomb bomb) {
		this.bomb = bomb;
	}
}
