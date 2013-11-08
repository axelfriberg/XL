package expr;

import model.Slot;

class Variable extends Expr implements Environment{
    private String name;

    Variable(String name) {
        this.name = name;
    }

    public String toString(int prec) {
        return name.toString();
    }

    public double value(Environment env) {
        return env.value(name);
    }

	public double value(String name) {
		return 0;
	}

	public Slot getSlot(String key) {
		return null;
	}
}