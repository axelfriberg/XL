package viewControl;

import java.util.Observable;

public class CurrentModel extends Observable {
	private SlotLabel currentSlot;

	public CurrentModel() {
		
	}

	public ColoredLabel getCurrent() {
		return currentSlot;
	}

	public void setCurrentSlot(SlotLabel currentSlot) {
		this.currentSlot = currentSlot;
		setChanged();
		notifyObservers();
	}
}
