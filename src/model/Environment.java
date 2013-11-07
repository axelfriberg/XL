package model;

public interface Environment {
    public double value(String name);
    
    public Slot getSlot(String key);
}