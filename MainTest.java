package test.mayuresh;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by naiveCode on 21/6/16.
 */
public class MainTest {

    @Test
    public void testMain() throws Exception {

    }
    @Test
    public void testParkingLotCreation() throws Exception {
        assertEquals("Created a parking lot with 6 slots",new Main().createParkingLot(6));
    }
    @Test
    public void testParkingLotParkForOneCar() throws Exception{
        Main m = new Main();
        m.createParkingLot(6);
        assertEquals("Allocated slot number: 1",m.addCar("KA\u00AD01\u00ADHH\u00AD1234 White"));
    }

    @Test
    public void testParkingLotParkForTwoCar() throws Exception{
        Main m = new Main();
        m.createParkingLot(6);
        assertEquals("Allocated slot number: 1",m.addCar("KA\u00AD01\u00ADHH\u00AD1234 White"));
        assertEquals("Allocated slot number: 2",m.addCar("KA\u00AD01\u00ADHI\u00AD1234 White"));
    }
    @Test
    public void testParkingLotParkForCapacityFull() throws Exception{
        Main m = new Main();
        m.createParkingLot(1);
        assertEquals("Allocated slot number: 1",m.addCar("KA\u00AD01\u00ADHH\u00AD1234 White"));
        assertEquals("Sorry, parking lot is full",m.addCar("KA\u00AD01\u00ADHI\u00AD1234 White"));
    }
    @Test
    public void testParkingLotLeaveForOneCar() throws Exception{
        Main m = new Main();
        m.createParkingLot(6);
        m.addCar("KA\u00AD01\u00ADHH\u00AD1234 White");
        assertEquals("Slot number 1 is free",m.leaveCar(1));

    }
    @Test
    public void testParkingLotLeaveForTwoCar() throws Exception{
        Main m = new Main();
        m.createParkingLot(6);
        m.addCar("KA\u00AD01\u00ADHH\u00AD1234 White");
        m.addCar("KA\u00AD01\u00ADHI\u00AD1234 White");
        assertEquals("Slot number 1 is free",m.leaveCar(1));
        assertEquals("Slot number 2 is free",m.leaveCar(2));
    }
    @Test
    public void testParkingLotStatusWhenCarIsAdded() throws Exception{
        Main m = new Main();
        m.createParkingLot(6);
        m.addCar("KA\u00AD01\u00ADHH\u00AD1234 White");
        m.addCar("KA\u00AD01\u00ADHI\u00AD1234 White");
        assertEquals("Slot No.  Registration No Colour \n" +
                "1  KA\u00AD01\u00ADHH\u00AD1234    White\n" +
                "2  KA\u00AD01\u00ADHI\u00AD1234    White\n"
                ,m.status());
    }
    @Test
    public void testParkingLotStatusWhenCarLeaves() throws Exception{
        Main m = new Main();
        m.createParkingLot(6);
        m.addCar("KA\u00AD01\u00ADHH\u00AD1234 White");
        m.addCar("KA\u00AD01\u00ADHI\u00AD1234 White");
        m.leaveCar(2);
        assertEquals("Slot No.  Registration No Colour \n" +
                        "1  KA\u00AD01\u00ADHH\u00AD1234    White\n"
                ,m.status());
    }

}