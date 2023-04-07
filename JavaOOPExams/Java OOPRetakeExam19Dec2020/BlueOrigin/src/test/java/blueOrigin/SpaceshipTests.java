package blueOrigin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SpaceshipTests {

    //TODO setName
    @Test
    public void testSetName(){
        Spaceship spaceship = new Spaceship("test", 10);
        assertEquals("test", spaceship.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNullNameThrow(){
        Spaceship spaceship = new Spaceship(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetEmptyNameThrow(){
        Spaceship spaceship = new Spaceship("", 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetEmptySpacesNameThrow(){
        Spaceship spaceship = new Spaceship("    ", 10);
    }



    //TODO setCapacity
    @Test
    public void testSetCapacityThrow(){
        Spaceship spaceship = new Spaceship("name", 10);
        assertEquals(10, spaceship.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNegativeCapacityThrow(){
        Spaceship spaceship = new Spaceship("name", -10);
    }



    //TODO add
    @Test
    public void testAddNormal(){
        Spaceship spaceship = new Spaceship("name", 10);
        Astronaut astronaut1 = new Astronaut("name1", 10);
        Astronaut astronaut2 = new Astronaut("name2", 10);
        Astronaut astronaut3 = new Astronaut("name3", 10);

        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
        assertEquals(3, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddOverTheCapacityThrow(){
        Spaceship spaceship = new Spaceship("name", 2);
        Astronaut astronaut1 = new Astronaut("name1", 10);
        Astronaut astronaut2 = new Astronaut("name2", 10);
        Astronaut astronaut3 = new Astronaut("name3", 10);

        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateAstronautNormal(){
        Spaceship spaceship = new Spaceship("name", 10);
        Astronaut astronaut1 = new Astronaut("name1", 10);
        Astronaut astronaut2 = new Astronaut("name2", 10);
        Astronaut astronaut3 = new Astronaut("name1", 10);

        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
    }



    //TODO remove
    @Test
    public void testRemoveNonExistentAstronautReturnFalse(){
        Spaceship spaceship = new Spaceship("name", 10);
        Astronaut astronaut1 = new Astronaut("name1", 10);

        spaceship.add(astronaut1);
        assertEquals(false, spaceship.remove("name"));
    }
    @Test
    public void testRemoveExistentAstronautReturnTrue(){
        Spaceship spaceship = new Spaceship("name", 10);
        Astronaut astronaut1 = new Astronaut("name1", 10);

        spaceship.add(astronaut1);
        assertEquals(true, spaceship.remove("name1"));
    }
}

