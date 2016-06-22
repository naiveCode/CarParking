package test.mayuresh;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by naiveCode on 21/6/16.
 */
public class MainTest {


    @Test
    public void testParkingLotCreation() throws Exception {
        assertEquals("Created a parking lot with 6 slots", new Main().createParkingLot(6));
    }

    @Test
    public void testParkingLotParkForOneCar() throws Exception {
        Main m = new Main();
        m.createParkingLot(6);
        assertEquals("Allocated slot number: 1", m.addCar("KA-01-HH-1234 White"));
    }

    @Test
    public void testParkingLotParkForTwoCar() throws Exception {
        Main m = new Main();
        m.createParkingLot(6);
        assertEquals("Allocated slot number: 1", m.addCar("KA-01-HH-1234 White"));
        assertEquals("Allocated slot number: 2", m.addCar("KA-01-HI-1234 White"));
    }

    @Test
    public void testParkingLotParkForCapacityFull() throws Exception {
        Main m = new Main();
        m.createParkingLot(1);
        assertEquals("Allocated slot number: 1", m.addCar("KA-01-HH-1234 White"));
        assertEquals("Sorry, parking lot is full", m.addCar("KA-01-HI-1234 White"));
    }

    @Test
    public void testParkingLotLeaveForOneCar() throws Exception {
        Main m = new Main();
        m.createParkingLot(6);
        m.addCar("KA-01-HH-1234 White");
        assertEquals("Slot number 1 is free", m.leaveCar(1));

    }

    @Test
    public void testParkingLotLeaveForTwoCar() throws Exception {
        Main m = new Main();
        m.createParkingLot(6);
        m.addCar("KA-01-HH-1234 White");
        m.addCar("KA-01-HI-1234 White");
        assertEquals("Slot number 1 is free", m.leaveCar(1));
        assertEquals("Slot number 2 is free", m.leaveCar(2));
    }

    @Test
    public void testParkingLotStatusWhenCarIsAdded() throws Exception {
        Main m = new Main();
        m.createParkingLot(6);
        m.addCar("KA-01-HH-1234 White");
        m.addCar("KA-01-HI-1234 White");
        assertEquals("Slot No.  Registration No Colour \n" +
                        "1  KA-01-HH-1234    White\n" +
                        "2  KA-01-HI-1234    White"
                , m.status());
    }

    @Test
    public void testParkingLotStatusWhenCarLeaves() throws Exception {
        Main m = new Main();
        m.createParkingLot(6);
        m.addCar("KA-01-HH-1234 White");
        m.addCar("KA-01-HI-1234 White");
        m.leaveCar(2);
        assertEquals("Slot No.  Registration No Colour \n" +
                        "1  KA-01-HH-1234    White"
                , m.status());
    }

    @Test
    public void testFindRegistrationNumberOfCarsWithColorWhite() throws Exception {
        Main m = new Main();
        m.createParkingLot(6);
        m.addCar("KA-01-HH-1234 White");
        m.addCar("KA-01-HH-9999 White");
        m.addCar("KA-01-P-333 White");
        m.addCar("KA-01-HI-1235 Red");
        assertEquals("KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333"
                , m.findRegistrationNumberOfCarsWithColour("White"));
    }
    @Test
    public void testFindSlotNumberOfCarsWithColorWhite() throws Exception {
        Main m = new Main();
        m.createParkingLot(6);
        m.addCar("KA-01-HH-1234 White");
        m.addCar("KA-01-HH-9999 White");
        m.addCar("KA-01-P-333 White");
        m.addCar("KA-01-HI-1235 Red");
        assertEquals("1, 2, 3"
                , m.findSlotNumberOfCarsWithColour("White"));
    }

    @Test
    public void testFindRegistrationNumberOfCarsWithColorRed() throws Exception {
        Main m = new Main();
        m.createParkingLot(6);
        m.addCar("KA-01-HH-1234 White");
        m.addCar("KA-01-HH-9999 White");
        m.addCar("KA-01-P-333 White");
        m.addCar("KA-01-HI-1235 Red");
        assertEquals("KA-01-HI-1235"
                , m.findRegistrationNumberOfCarsWithColour("Red"));
    }
    @Test
    public void testFindSlotNumberOfCarsWithRegistrationNumber() throws Exception {

        Main m = new Main();
        m.createParkingLot(6);
        m.addCar("KA­01­HH­1234 White");
        m.addCar("KA­01­HH­9999 White");
        m.addCar("KA­01­BB­0001 Black");
        m.addCar("KA­01­HH­7777 Red");
        m.addCar("KA­01­HH­2701 Blue");
        m.addCar("KA-01-HH-3141 Black");
        assertEquals("6"
                , m.findSlotNumberOfCarsWithRegistrationNumber("KA-01-HH-3141"));
    }

    @Test
    public void testFindSlotNumberOfCarsWithRegistrationNumberWhenCarNotPresent() throws Exception {


        Main m = new Main();
        m.createParkingLot(6);
        m.addCar("KA-01-HH-1234 White");
        m.addCar("KA-01-HH-9999 White");
        m.addCar("KA-01-P-333 White");
        m.addCar("KA-01-HI-1235 Red");
        assertEquals("Not found"
                , m.findSlotNumberOfCarsWithRegistrationNumber("KA\u00AD01\u00ADHH\u00AD314"));
    }
}