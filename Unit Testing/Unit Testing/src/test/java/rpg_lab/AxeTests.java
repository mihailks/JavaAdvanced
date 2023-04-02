package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

public class AxeTests {


    @Test
    public void testDurability() {
        //Arrange
        Axe axe = new Axe(10,10);
        Dummy target = new Dummy(10, 10);

        //Act
        axe.attack(target);

        //Assert
        Assert.assertTrue(axe.getDurabilityPoints()==9);

    }

    @Test(expected = IllegalStateException.class)
    public void testAttackBroken(){
        //Arrange
        Axe axe = new Axe(10,0);
        Dummy target = new Dummy(10, 10);

        //Act
        axe.attack(target);


        //Assert

    }

}
