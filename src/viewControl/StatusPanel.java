package viewControl;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import model.Sheet;

@SuppressWarnings("serial")
public class StatusPanel extends BorderPanel {
    protected StatusPanel(StatusLabel statusLabel, Sheet sheet) {
    	super(sheet);
        add(WEST, new CurrentLabel(sheet));
        add(CENTER, statusLabel);
    }
}