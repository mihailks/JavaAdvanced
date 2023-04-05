package toyStore;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ToyStoryTest {

    @Test
    public void testToyShelf(){
        ToyStore toyStore = new ToyStore();
        Map<String, Toy> testShelf = new LinkedHashMap<>();
        testShelf.put("A", null);
        testShelf.put("B", null);
        testShelf.put("C", null);
        testShelf.put("D", null);
        testShelf.put("E", null);
        testShelf.put("F", null);
        testShelf.put("G", null);
        assertEquals(testShelf, toyStore.getToyShelf());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSameToyTwice() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("test", "test");
        Toy toy2 = new Toy("test2", "test2");
        toyStore.addToy("A", toy1);
        toyStore.addToy("B",toy2);
        toyStore.addToy("B",toy2);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSToyOnTheSameRow() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("test", "test");
        Toy toy2 = new Toy("test2", "test2");
        toyStore.addToy("A", toy1);
        toyStore.addToy("A",toy2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToyShelfNonExtant() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("test", "test");
        toyStore.addToy("AA", toy1);
    }

    @Test
    public void testGetToyShelf() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("test", "test");
        Toy toy2 = new Toy("test2", "test2");
        toyStore.addToy("A", toy1);
        toyStore.addToy("B",toy2);

        Toy testToy = toyStore.getToyShelf().get("A");

        assertEquals(testToy,toy1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddSameToyTwiceOnDifferentShelf() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("test", "test");
        toyStore.addToy("A", toy1);
        toyStore.addToy("B", toy1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFromNonexistentShelf() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("test", "test");
        toyStore.addToy("A", toy1);
        toyStore.removeToy("AA", toy1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFromNonexistentToy() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("test", "test");
        Toy toy2 = new Toy("test2", "test2");
        toyStore.addToy("A", toy1);
        toyStore.addToy("B", toy2);
        toyStore.removeToy("A", toy2);
    }

    @Test
    public void RemoveExistentToy() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("test", "test");
        Toy toy2 = new Toy("test2", "test2");
        toyStore.addToy("A", toy1);
        toyStore.addToy("B", toy2);
        String result =  toyStore.removeToy("A", toy1);

        assertEquals("Remove toy:test successfully!", result);
    }



}