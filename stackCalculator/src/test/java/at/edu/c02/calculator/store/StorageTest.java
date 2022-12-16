package at.edu.c02.calculator.store;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.CalculatorException;
import at.edu.c02.calculator.StorageException;
import at.edu.c02.calculator.logic.CalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StorageTest {

    @Test
    public void positiveStorageTest() throws StorageException {
        Storage storage = new Storage();

        storage.store("A", 17.0);

        assertEquals(17.0, storage.load("A"), 0);

        storage.store("B", 18.0);
        storage.store("A", 15.0);

        assertEquals(15.0, storage.load("A"), 0);
        assertEquals(18.0, storage.load("B"), 0);
    }

    @Test
    public void negativeStorageTest(){

        Storage storage = new Storage();

        try {
            storage.store("A", 17.0);
            storage.store("B", 18.0);

            storage.load("C");
            fail("Exception expected");


        } catch (StorageException e) {
            assertEquals("Error: Could not find identifier!", e.getMessage());
        }
    }
}
