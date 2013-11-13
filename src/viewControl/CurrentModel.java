package viewControl;

import java.util.Observable;

public class CurrentModel extends Observable {
	private SlotLabel currentSlot;
	private String errorMsg = "";

	public CurrentModel() {

	}

	public ColoredLabel getCurrent() {
		return currentSlot;
	}

	public void setCurrentSlot(SlotLabel nextCurrentSlot) {
		if (currentSlot == null) {
			this.currentSlot = nextCurrentSlot;
			setChanged();
			notifyObservers();
		} else if (!(currentSlot.equals(nextCurrentSlot))) {
			this.currentSlot = nextCurrentSlot;
			setChanged();
			notifyObservers();
		}
	}
	
	public void setErrorMessage(String s){
		errorMsg= s;
		setChanged();
		notifyObservers();
	}
	
	public String getExceptionMessage(){
		String temp = errorMsg;
		errorMsg = "";	
		return temp;
	}
}
