package model;


public class CommentSlot implements Slot {

	private String comment;

	public CommentSlot(String s) {
		comment = s.substring(1);
	}

	public double value() {
//		throw new XLException("Comment value request.");
		return 0;
	}

	public String toString() {
		return "#" + comment;
	}

	public String output() {
		return comment;
	}

}
