package farmville;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FarmvilleTests {

    //TODO setName
    @Test
    public void testSetName(){
        Farm farm = new Farm("name", 10);
        assertEquals("name", farm.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetZeroName(){
        Farm farm = new Farm("", 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNullName(){
        Farm farm = new Farm(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetEmptyName(){
        Farm farm = new Farm("    ", 10);
    }

    //TODO setName
    @Test
    public void testSetCapacity(){
        Farm farm = new Farm("name", 10);
        assertEquals(10, farm.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNegativeCapacity(){
        Farm farm = new Farm("name", -10);
    }

    //TODO add
    @Test(expected = IllegalArgumentException.class)
    public void testFullFarm(){
        Farm farm = new Farm("name", 2);
        Animal animal1 = new Animal("dog1", 10);
        Animal animal2 = new Animal("dog2", 10);
        Animal animal3 = new Animal("dog3", 10);
        farm.add(animal1);
        farm.add(animal2);
        farm.add(animal3);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateAnimalFarm(){
        Farm farm = new Farm("name", 10);
        Animal animal1 = new Animal("dog1", 10);
        Animal animal2 = new Animal("dog2", 10);
        Animal animal3 = new Animal("dog1", 10);
        farm.add(animal1);
        farm.add(animal2);
        farm.add(animal3);
    }

    @Test
    public void testNormalAdd(){
        Farm farm = new Farm("name", 10);
        Animal animal1 = new Animal("dog1", 10);
        Animal animal2 = new Animal("dog2", 10);
        Animal animal3 = new Animal("dog3", 10);
        farm.add(animal1);
        farm.add(animal2);
        farm.add(animal3);
        assertEquals(3, farm.getCount());
    }


    //TODO remove
    @Test
    public void testRemoveNonExistentAnimal(){
        Farm farm = new Farm("name", 2);
        Animal animal1 = new Animal("dog1", 10);
        farm.add(animal1);

        assertEquals(false, farm.remove("name11"));
    }


    @Test
    public void testNormalRemove(){
        Farm farm = new Farm("name", 2);
        Animal animal1 = new Animal("dog1", 10);
        farm.add(animal1);

        assertEquals(true, farm.remove(animal1.getType()));
    }


}
























