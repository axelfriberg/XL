package viewControl;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import model.Sheet;

@SuppressWarnings("serial")
public class StatusPanel extends BorderPanel {
	protected StatusPanel(StatusLabel statusLabel, Sheet sheet,
			CurrentModel currentModel) {
		super(sheet);

		add(WEST, new CurrentLabel(currentModel));
		add(CENTER, statusLabel);
	}
}