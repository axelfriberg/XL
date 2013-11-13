package viewControl;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("serial")
public class SlotLabel extends ColoredLabel implements Observer, MouseListener {

	private int row;
	private char column;
	private CurrentModel currentModel;

	public SlotLabel(int row, char column, CurrentModel currentModel) {
		super("                    ", Color.WHITE, RIGHT);
		this.row = row;
		this.column = column;
		this.currentModel = currentModel;
		addMouseListener(this);

	}

	public String toString() {
		return Character.toString(column) + Integer.toString(row);
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		if (!(currentModel.getCurrent().equals(this))) {
			setBackground(Color.WHITE);
			currentModel.deleteObserver(this);
		}

	}

	public boolean equals(Object obj) {
		String a = obj.toString();
		String b = toString();
		if (a == null) {
			return false;
		} else if (b == null) {
			return false;
		} else if (a.equals(b)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		setBackground(Color.YELLOW);
		currentModel.setCurrentSlot(this);
		currentModel.addObserver(this);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}