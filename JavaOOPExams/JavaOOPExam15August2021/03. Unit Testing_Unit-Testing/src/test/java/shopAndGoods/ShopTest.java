package shopAndGoods;


import org.junit.Test;


import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class ShopTest {

    @Test(expected = UnsupportedOperationException.class)
    public void testGetShelvesShouldReturnUnmodifiable() {
        Shop shop = new Shop();
        shop.getShelves().clear();
    }
    //add
    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldThrowNoShelf() throws OperationNotSupportedException {
        Shop shop = new Shop();
        shop.addGoods("AA", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldThrowShelfFull() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("test", "test1");
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves1", goods);
    }

    @Test
    public void testAddGoodsShouldReturnCorrectMessage() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("test", "test1");
        String expected = "Goods: test1 is placed successfully!";
        String actual = shop.addGoods("Shelves1", goods);
        assertEquals(expected, actual);
    }

    //remove
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldThrowNoShelf() {
        Shop shop = new Shop();
        shop.removeGoods("AA", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldThrowShelfFull() {
        Shop shop = new Shop();
        Goods goods = new Goods("test", "test1");
        shop.removeGoods("Shelves1", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveDifferentGoodFromFullShelf() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("test", "test1");
        Goods goods2 = new Goods("test2", "test2");
        shop.addGoods("Shelves1",goods);
        shop.addGoods("Shelves2",goods2);
        shop.removeGoods("Shelves2", goods);
    }

    @Test
    public void testRemoveGoodsShouldReturnCorrectMessage() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("test", "test1");
        shop.addGoods("Shelves1", goods);

        String expected = "Goods: test1 is removed successfully!";
        String actual = shop.removeGoods("Shelves1", goods);

        assertEquals(expected, actual);
    }
    @Test
    public void testNullShelfAfterRemove() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("test", "test1");
        shop.addGoods("Shelves1", goods);

        shop.removeGoods("Shelves1", goods);

        Goods goods1 = shop.getShelves().get("Shelves1");

        assertEquals(null,goods1);

    }


}






















