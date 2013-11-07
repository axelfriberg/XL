package viewControl;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

public class Editor extends JTextField implements KeyListener, Observer { //Key och Obs tillagda 
	public Editor() { 
		setBackground(Color.WHITE);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		if (arg0.VK_ENTER == arg0.getKeyCode()) { //h�r eller i keyPressed
			String s = getText();
			//skicka s till model
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setText("");//T�mmer efter att modellen tagit emot str�ngen och gjort det den ska
	}
}