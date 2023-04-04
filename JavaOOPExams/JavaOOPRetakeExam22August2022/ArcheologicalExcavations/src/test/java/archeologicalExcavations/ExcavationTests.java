package archeologicalExcavations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExcavationTests {
    @Test(expected = NullPointerException.class)
    public void testCreateExcavationTrowWhenNull() {
        Excavation excavation = new Excavation(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCapacityWhenLessThanZero() {
        Excavation excavation = new Excavation("name", -10);
    }

    @Test
    public void testGetCountIsZeroOnEmptyExcavation() {
        Excavation excavation = new Excavation("name", 10);

        assertEquals(0, excavation.getCount());
    }

    @Test
    public void testGetCountNonZeroOnEmptyExcavation() {
        Excavation excavation = new Excavation("name", 10);
        Archaeologist archaeologist1 = new Archaeologist("Gogo", 50);
        Archaeologist archaeologist2 = new Archaeologist("Toto", 70);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);

        assertEquals(2, excavation.getCount());
    }

    @Test
    public void testGetNameExcavation() {
        Excavation excavation = new Excavation("name", 10);

        assertEquals("name", excavation.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddOverTheCapacity() {
        Excavation excavation = new Excavation("name", 2);
        Archaeologist archaeologist1 = new Archaeologist("Misho", 100);
        Archaeologist archaeologist2 = new Archaeologist("Mariya", 100);
        Archaeologist archaeologist3 = new Archaeologist("Tosho", 50);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddExistingArcheologistTrows() {
        Excavation excavation = new Excavation("name", 10);
        Archaeologist archaeologist1 = new Archaeologist("Misho", 100);
        Archaeologist archaeologist2 = new Archaeologist("Mariya", 100);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist2);
    }
    @Test
    public void testRemoveArcheologistWhenExisting(){
        Excavation excavation = new Excavation("name", 10);
        Archaeologist archaeologist1 = new Archaeologist("Misho", 100);
        Archaeologist archaeologist2 = new Archaeologist("Mariya", 100);
        Archaeologist archaeologist3 = new Archaeologist("Tosho", 50);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);

        boolean isRemoved = excavation.removeArchaeologist(archaeologist3.getName());

        assertTrue(isRemoved);
        assertEquals(2, excavation.getCount());
    }
    @Test
    public void testAddNormal(){
        Excavation excavation = new Excavation("name", 10);
        Archaeologist archaeologist1 = new Archaeologist("Misho", 100);
        Archaeologist archaeologist2 = new Archaeologist("Mariya", 100);
        Archaeologist archaeologist3 = new Archaeologist("Tosho", 50);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);

        assertEquals(3, excavation.getCount());
    }
}
