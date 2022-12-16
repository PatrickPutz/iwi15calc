package at.edu.c02.calculator.store;

import at.edu.c02.calculator.StorageException;

import java.util.HashMap;

public class Storage {

    private HashMap<String, Double> storage;

    public Storage(){
        this.storage = new HashMap<>();
    }

    public void store(String name, double value){
        storage.put(name, value);
    }

    public double load(String name) throws StorageException {
        if(storage.containsKey(name))
            return storage.get(name);
        else
            throw new StorageException("Error: Could not find identifier!");
    }
}
