package robots;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ServiceTests {

    //TODO setName
    @Test(expected = NullPointerException.class)
    public void testSetNameNullTrow(){
        Service service = new Service(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameSpaceTrow(){
        Service service = new Service("     ", 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameEmptyTrow(){
        Service service = new Service("", 10);
    }

    @Test
    public void testSetName(){
        Service service = new Service("name", 10);
        assertEquals("name", service.getName());
    }



    //TODO setCapacity
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityNegativeTrow(){
        Service service = new Service("name", -10);
    }

    @Test
    public void testSetCapacityZeroTrow(){
        Service service = new Service("name", 0);
    }

    @Test
    public void testSetCapacity(){
        Service service = new Service("name", 10);
        assertEquals(10, service.getCapacity());
    }



    //TODO addRobot
    @Test(expected = IllegalArgumentException.class)
    public void testAddRobotOverCapacity(){
        Service service = new Service("name", 2);
        Robot robot1 = new Robot("name1");
        Robot robot2 = new Robot("name2");
        Robot robot3 = new Robot("name3");
        service.add(robot1);
        service.add(robot2);
        service.add(robot3);
    }

    @Test
    public void dup(){
        Service service = new Service("name", 10);
        Robot robot1 = new Robot("name1");
        Robot robot2 = new Robot("name2");
        Robot robot3 = new Robot("name1");
        service.add(robot1);
        service.add(robot2);
        service.add(robot3);
    }


    @Test
    public void testAddRobot(){
        Service service = new Service("name", 10);
        Robot robot1 = new Robot("name1");
        Robot robot2 = new Robot("name2");
        Robot robot3 = new Robot("name3");
        service.add(robot1);
        service.add(robot2);
        service.add(robot3);

        assertEquals(3, service.getCount());

    }



    //TODO removeRobot
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveRobotNonExistentRobot(){
        Service service = new Service("name", 10);
        Robot robot1 = new Robot("name1");
        Robot robot2 = new Robot("name2");
        service.add(robot1);
        service.remove("name2");
    }

    @Test
    public void testRemoveRobot(){
        Service service = new Service("name", 10);
        Robot robot1 = new Robot("name1");
        Robot robot2 = new Robot("name2");
        service.add(robot1);
        service.add(robot2);
        assertEquals(2, service.getCount());

        service.remove("name2");
        assertEquals(1, service.getCount());

    }



    //TODO forSaleRobot
    @Test(expected = IllegalArgumentException.class)
    public void testForSaleRobotNonExistent(){
        Service service = new Service("name", 10);
        Robot robot1 = new Robot("name1");
        service.add(robot1);
        service.forSale("name2");
    }

    @Test
    public void testForSaleRobot(){
        Service service = new Service("name", 10);
        Robot robot1 = new Robot("name1");
        Robot robot2 = new Robot("name2");
        service.add(robot1);
        service.add(robot2);
        Robot actual = service.forSale("name2");
        boolean readyForSale = robot2.isReadyForSale();
        robot2.setReadyForSale(false);
        assertEquals(robot2, actual);
    }

    @Test
    public void testForSaleRobotTrue(){
        Service service = new Service("name", 10);
        Robot robot1 = new Robot("name1");
        Robot robot2 = new Robot("name2");
        service.add(robot1);
        service.add(robot2);
        //Robot actual = service.forSale("name2");
        boolean readyForSale = robot2.isReadyForSale();
        assertEquals(true, readyForSale);
    }

    @Test
    public void testForSaleRobotfalse(){
        Service service = new Service("name", 10);
        Robot robot1 = new Robot("name1");
        Robot robot2 = new Robot("name2");
        service.add(robot1);
        service.add(robot2);
        Robot actual = service.forSale("name2");
        robot2.setReadyForSale(false);
        boolean readyForSale = robot2.isReadyForSale();
        assertEquals(false, readyForSale);
    }

    //TODO report
    @Test
    public void testReport(){
        Service service = new Service("name", 10);
        Robot robot1 = new Robot("name1");
        Robot robot2 = new Robot("name2");
        service.add(robot1);
        service.add(robot2);
        String expected =  "The robot name1, name2 is in the service name!";
        String actual = service.report();

        assertEquals(expected, actual);
    }

    @Test
    public void testReportSingle(){
        Service service = new Service("name", 10);
        Robot robot1 = new Robot("name1");
        service.add(robot1);
        String expected =  "The robot name1 is in the service name!";
        String actual = service.report();

        assertEquals(expected, actual);
    }

    @Test
    public void testReportArr(){
        Service service = new Service("name", 10);
        Robot robot1 = new Robot("name1");
        Robot robot2 = new Robot("name2");
        service.add(robot1);
        service.add(robot2);
        List<Robot> robotsList = new ArrayList<>();
        robotsList.add(robot1);
        robotsList.add(robot2);
        String names = robotsList.stream().map(Robot::getName).collect(Collectors.joining(", "));
        String expected =  String.format("The robot %s is in the service name!",names);
        String actual = service.report();

        assertEquals(expected, actual);
    }


    //TODO forSaleRobot
    @Test(expected = IllegalArgumentException.class)
    public void testNonExistentRobotForSaleTrows(){
        Service service = new Service("name", 10);
        service.forSale("nameNonExistent");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNonExistentRobotForSale(){
        Service service = new Service("name", 10);
        service.forSale("nameNonExistent");
        assertEquals(null, service.forSale("name3"));
    }

    @Test
    public void testRobotReadyForSale(){
        Service service = new Service("name", 10);
        Robot robot = new Robot("name");
        service.add(robot);

        service.forSale("name");

        robot.setReadyForSale(false);

        assertEquals(robot, service.forSale("name"));
    }

    @Test
    public void testRobotReadyForSaleTrue(){
        Service service = new Service("name", 10);
        Robot robot = new Robot("name");

        service.add(robot);

        assertEquals(robot, service.forSale("name"));
    }

    @Test
    public void testRobotReadyForSaleTrueREV02(){
        Service service = new Service("name", 10);
        Robot robot = new Robot("name");
        robot.setReadyForSale(false);
        service.add(robot);

        assertFalse(robot.isReadyForSale());
    }

    @Test
    public void testRobotReadyForSaleTrueREV03(){
        Service service = new Service("name", 10);
        Robot robot = new Robot("name");
        robot.setReadyForSale(true);
        service.add(robot);

        assertTrue(robot.isReadyForSale());
    }

    @Test
    public void testRobotReadyForSaleTrueREV04(){
        Service service = new Service("name", 10);
        Robot robot = new Robot("name");
        service.add(robot);
        robot.setReadyForSale(false);

        assertFalse(robot.isReadyForSale());
    }

    @Test
    public void testRobotReadyForSaleTrueREV05(){
        Service service = new Service("name", 10);
        Robot robot = new Robot("name");
        service.add(robot);
        robot.setReadyForSale(true);

        assertTrue(robot.isReadyForSale());
    }

    @Test
    public void testRobotReadyForSaleTrueREV06(){
        Service service = new Service("name", 10);
        Robot robot = new Robot("name");
        service.add(robot);
        service.forSale(robot.getName());

        assertFalse(robot.isReadyForSale());
    }

//    @Test
//    public void testRobotReadyForSaleTrueREV07(){
//        Service service = new Service("name", 10);
//        Robot robot = new Robot("name");
//        service.add(robot);
//        robot.setReadyForSale(true);
//
//        assertTrue(robot.isReadyForSale());
//    }






}
























