package football;

import org.junit.Test;

import static org.junit.Assert.*;

public class FootballTeamTests {
    @Test
    public void testGetName() {
        FootballTeam footballTeam = new FootballTeam("testName", 11);
        assertEquals("testName", footballTeam.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameNullTrows() {
        FootballTeam footballTeam = new FootballTeam(null, 11);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameEmptySpaceTrows() {
        FootballTeam footballTeam = new FootballTeam("    ", 11);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameEmptyTrows() {
        FootballTeam footballTeam = new FootballTeam("", 11);
    }

    @Test
    public void testGetVacantPositions() {
        FootballTeam footballTeam = new FootballTeam("testName", 11);
        assertEquals(11, footballTeam.getVacantPositions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetVacantPositionsNegative() {
        FootballTeam footballTeam = new FootballTeam("testName", -11);
    }

    @Test
    public void testGetVacantPositionsZero() {
        FootballTeam footballTeam = new FootballTeam("testName", 0);
    }

    @Test
    public void testGetCountNonZeroFootBallerInTeam() {
        FootballTeam footballTeam = new FootballTeam("testName", 11);
        Footballer footballer1 = new Footballer("test1");
        Footballer footballer2 = new Footballer("test2");
        Footballer footballer3 = new Footballer("test3");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);

        assertEquals(3, footballTeam.getCount());
    }

    @Test
    public void testAddFootballer() {
        FootballTeam footballTeam = new FootballTeam("testName", 11);
        Footballer footballer1 = new Footballer("test1");
        Footballer footballer2 = new Footballer("test2");
        Footballer footballer3 = new Footballer("test3");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);

        assertEquals(3, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerWhenTeamFullThrow() {
        FootballTeam footballTeam = new FootballTeam("testName", 2);
        Footballer footballer1 = new Footballer("test1");
        Footballer footballer2 = new Footballer("test2");
        Footballer footballer3 = new Footballer("test3");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
    }

    @Test
    public void testRemoveFootballerInTheTeam() {
        FootballTeam footballTeam = new FootballTeam("testName", 11);
        Footballer footballer1 = new Footballer("test1");
        Footballer footballer2 = new Footballer("test2");
        Footballer footballer3 = new Footballer("test3");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        assertEquals(3, footballTeam.getCount());
        footballTeam.removeFootballer("test1");
        assertEquals(2, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerNotInTheTeamTrows() {
        FootballTeam footballTeam = new FootballTeam("testName", 11);
        Footballer footballer1 = new Footballer("test1");
        Footballer footballer2 = new Footballer("test2");
        Footballer footballer3 = new Footballer("test3");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        footballTeam.removeFootballer("Test4");
    }

    @Test
    public void testFootballerForSaleDeactivatePlayer(){
        FootballTeam footballTeam = new FootballTeam("testName", 11);
        Footballer footballer1 = new Footballer("test1");
        footballTeam.addFootballer(footballer1);

        footballTeam.footballerForSale(footballer1.getName());
        assertFalse(footballer1.isActive());

    }
    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleNoSuchPlayerTrows() {
        FootballTeam footballTeam = new FootballTeam("testName", 11);
        Footballer footballer1 = new Footballer("test1");
        footballTeam.addFootballer(footballer1);
        footballTeam.footballerForSale("nope");
    }


















    @Test
    public void testGetStatistics() {
        FootballTeam footballTeam = new FootballTeam("testName", 11);
        Footballer footballer1 = new Footballer("test1");
        Footballer footballer2 = new Footballer("test2");
        Footballer footballer3 = new Footballer("test3");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);

        String expected = "The footballer test1, test2, test3 is in the team testName.";

        assertEquals(expected, footballTeam.getStatistics());
    }

}
