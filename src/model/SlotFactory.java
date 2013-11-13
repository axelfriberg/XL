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
			try {
				ExprSlot exprSlot = new ExprSlot(s, env);
				return exprSlot;
			} catch (XLException e) {
				throw e;
			}
		}

	}
}
