package viewControl;

import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

import model.Sheet;

class LoadMenuItem extends OpenMenuItem {
	private Sheet sheet;
	
    public LoadMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
        super(xl, statusLabel, "Load");
        this.sheet = sheet;
    }

    protected void action(String path) throws FileNotFoundException {
    	try{
        sheet.load(path);
    	}catch(Exception e){
    		statusLabel.setText(e.getMessage());
    	}
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}