package model;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import expr.Expr;
import expr.ExprParser;

public class ExprSlot implements Slot {

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
			throw new XLException(e.getMessage());
		}
		try {
			expr.value(env);
		} catch (XLException e) {
			throw e;
		}

	}

	public double value() {
		return expr.value(env);

	}

	public String toString() {
		return expr.toString();
	}

	public String output() {
		return String.valueOf(value());
	}
}
