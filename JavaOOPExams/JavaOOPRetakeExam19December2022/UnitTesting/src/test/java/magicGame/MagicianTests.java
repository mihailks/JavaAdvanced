package magicGame;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MagicianTests {

    @Test(expected = NullPointerException.class)
    public void testSetUserNameNullTrow() {
        Magician magician = new Magician(null, 100);
    }

    @Test(expected = NullPointerException.class)
    public void testSetUserNameEmptyTrow() {
        Magician magician = new Magician("     ", 100);
    }

    @Test()
    public void testSetValidUserName() {
        Magician magician = new Magician("Gosho", 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthNegativeTrow() {
        Magician magician = new Magician("Gosho", -100);
    }

    @Test()
    public void testSetValidHealth() {
        Magician magician = new Magician("Gosho", 100);
    }

    @Test()
    public void testGetUserName() {
        Magician magician = new Magician("Gosho", 100);
        assertEquals("Gosho", magician.getUsername());
    }

    @Test()
    public void testGetUserHealth() {
        Magician magician = new Magician("Gosho", 100);
        assertEquals(100, magician.getHealth());
    }

    @Test()
    public void testGetHealthEqualsZero() {
        Magician magician = new Magician("Gosho", 0);
        assertEquals(0, magician.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void testSetMagicNameNullTrow() {
        Magician magician = new Magician("Gosho", 100);
        magician.addMagic(null);
    }

    @Test()
    public void testSetValidMagicName() {
        Magic magic = new Magic("FireBall", 100);
    }

    @Test
    public void testAddToMagicCollection() {
        Magician magician = new Magician("Gosho", 100);
        Magic magic1 = new Magic("FireBall", 100);
        Magic magic2 = new Magic("FireBlast", 100);
        magician.addMagic(magic1);
        magician.addMagic(magic2);
        assertEquals(2, magician.getMagics().size());
    }

    @Test
    public void testRemoveFromMagicCollection() {
        Magician magician = new Magician("Gosho", 100);
        Magic magic1 = new Magic("FireBall", 100);
        Magic magic2 = new Magic("FireBlast", 100);
        magician.addMagic(magic1);
        magician.addMagic(magic2);

        boolean isRemoved = magician.removeMagic(magic1);

        assertTrue(isRemoved);
        assertEquals(1, magician.getMagics().size());
    }

    @Test
    public void testTakeHaveHealthDamage() {
        Magician magician = new Magician("Gosho", 100);
        magician.takeDamage(50);
        assertEquals(50, magician.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageThrowException() {
        Magician magician = new Magician("Gosho", 0);
        magician.takeDamage(10);
    }

    @Test
    public void testReturnFromMagicCollection() {
        Magician magician = new Magician("Gosho", 100);
        Magic magic = new Magic("FireBall", 100);
        magician.addMagic(magic);

        List<Magic> expected = List.of(magic);

        assertEquals(expected, magician.getMagics());
    }
}
