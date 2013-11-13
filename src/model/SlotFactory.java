package model;

public class SlotFactory {
	private Environment env;

	public SlotFactory(Environment env) {
		this.env = env;
	}

	public Slot createSlot(String s) {

		if (s.charAt(0) == '#') {
			return new CommentSlot(s);
		}

		else {
			Slot exprSlot;
			try {
				exprSlot = new ExprSlot(s, env);
			} catch (XLException e) {
				exprSlot = new BlankSlot();
				throw e;
			}
			return exprSlot;
		}

	}
}
