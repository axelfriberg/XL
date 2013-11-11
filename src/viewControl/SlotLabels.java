package viewControl;

import java.awt.Color;

import model.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SlotLabels extends GridPanel implements MouseListener, Observer {
	private HashMap<String, SlotLabel> labelList;
	private SlotLabel currentLabel;
	private Sheet sheet;
	private CurrentModel currentModel;

	public SlotLabels(int rows, int cols, Sheet sheet, CurrentModel currentModel) {
		super(rows + 1, cols);
		this.sheet = sheet;
		this.currentModel = currentModel;
		sheet.addObserver(this);
		labelList = new HashMap<String, SlotLabel>();
		for (char ch = 'A'; ch < 'A' + cols; ch++) {
			add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
					SwingConstants.CENTER));
		}
		for (int row = 1; row <= rows; row++) {
			for (char ch = 'A'; ch < 'A' + cols; ch++) {
				SlotLabel label = new SlotLabel(row, ch, currentModel);
				add(label);
				String temp = Character.toString(ch) + Integer.toString(row);
				labelList.put(temp, label);
			}
		}
		currentModel.setCurrentSlot(labelList.get("A1"));
		currentModel.addObserver(labelList.get("A1"));
		labelList.get("A1").setBackground(Color.YELLOW);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

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
		HashMap<String, String> slotNames = sheet.getSlotList();
		for (Map.Entry<String, String> entry : slotNames.entrySet()) {
			labelList.get(entry.getKey()).setText(entry.getValue());

		}
	}

}
