package viewControl;

import java.awt.Color;

@SuppressWarnings("serial")
public class SlotLabel extends ColoredLabel {

	private int row;
	private char column;

	public SlotLabel(int row, char column) {
		super("                    ", Color.WHITE, RIGHT);
		this.row = row;
		this.column = column;
	}

	public String toString() {
		return Character.toString(column) + Integer.toString(row);
	}
}