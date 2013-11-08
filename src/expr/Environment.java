package expr;

import model.Slot;

public interface Environment {
    public double value(String name);
    
    public Slot getSlot(String key);
}