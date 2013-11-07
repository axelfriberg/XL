package viewControl;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import model.Sheet;

@SuppressWarnings("serial")
public class SheetPanel extends BorderPanel {
    public SheetPanel(int rows, int columns, Sheet sheet) {
    	super(sheet);
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns, sheet));
    }
}