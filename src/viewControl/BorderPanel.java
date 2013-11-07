package viewControl;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import model.Sheet;

@SuppressWarnings("serial")
public class BorderPanel extends JPanel {
    protected BorderPanel(Sheet sheet) {
        super(new BorderLayout(2, 2));
        setBackground(Color.BLACK);
    }
}
