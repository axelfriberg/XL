package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

//TODO move to another package
public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    // TODO Change Object to something appropriate
    public void load(Map<String, Slot> map, SlotFactory factory) {
        try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');
                String key = string.substring(0, i);
                String value = string.substring(i+1);
                map.put(key, factory.createSlot(value));
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
