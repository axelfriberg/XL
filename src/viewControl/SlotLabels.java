package viewControl;

import java.awt.Color;

import model.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SlotLabels extends GridPanel implements MouseListener, Observer {
	private List<SlotLabel> labelList;
	private SlotLabel currentLabel;
	private Sheet sheet;

	public SlotLabels(int rows, int cols, Sheet sheet) {
		super(rows + 1, cols);
		this.sheet = sheet;
		sheet.addObserver(this);
		labelList = new ArrayList<SlotLabel>(rows * cols);
		for (char ch = 'A'; ch < 'A' + cols; ch++) {
			add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
					SwingConstants.CENTER));
		}
		for (int row = 1; row <= rows; row++) {
			for (char ch = 'A'; ch < 'A' + cols; ch++) {
				SlotLabel label = new SlotLabel(row, ch);
				label.addMouseListener(this);
				add(label);
				labelList.add(label);
			}
		}
		SlotLabel firstLabel = labelList.get(0);
		firstLabel.setBackground(Color.YELLOW);
		currentLabel = firstLabel;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		boolean found = false;
		for (SlotLabel label : labelList) {
			if (arg0.getSource().equals(label) && !found) {
				currentLabel.setBackground(Color.WHITE);
				currentLabel = label;
				currentLabel.setBackground(Color.YELLOW);
				found = true;
				sheet.updateCurrent(label.toString());
			}

		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Observable o, Object arg) {

	}

}
