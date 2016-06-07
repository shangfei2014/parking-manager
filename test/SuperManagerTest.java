import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SuperManagerTest {
    private Car car;
    private ParkingLot parkingLot_11;
    private ParkingLot parkingLot_12;
    private List<ParkingLot> parkingLotList_1 = new ArrayList<ParkingLot>();
    private ParkingService parkingBoy_11;
    private ParkingService parkingBoy_12;
    private ParkingService parkingBoy_13;
    private List<ParkingService> parkingBoyList_1 = new ArrayList<ParkingService>();
    private ParkingService manager_1;

    private ParkingLot parkingLot_21;
    private ParkingLot parkingLot_22;
    private List parkingLotList_2 = new ArrayList<ParkingLot>();
    private ParkingService parkingBoy_21;
    private ParkingService parkingBoy_22;
    private ParkingService parkingBoy_23;
    private List parkingBoyList_2 = new ArrayList<ParkingService>();
    private ParkingService manager_2;

    private List<ParkingService> managerList = new ArrayList<ParkingService>();
    private ParkingService superManager;

    @Before
    public void setUp() throws Exception {
        car = new Car("M11");
        parkingLot_11 = new ParkingLot(5,1);
        parkingLot_12 = new ParkingLot(5,2);
        parkingLotList_1.add(parkingLot_11);
        parkingLotList_1.add(parkingLot_12);
        parkingBoy_11 = new ParkingBoy(new NormalBoy(),parkingLotList_1);
        parkingBoy_12 = new ParkingBoy(new CompareBoy(),parkingLotList_1);
        parkingBoy_13 = new ParkingBoy(new CalculateBoy(),parkingLotList_1);
        parkingBoyList_1.add(parkingBoy_11);
        parkingBoyList_1.add(parkingBoy_12);
        parkingBoyList_1.add(parkingBoy_13);
        manager_1 = new Manager(parkingBoyList_1);

        parkingLot_21 = new ParkingLot(5,3);
        parkingLot_22 = new ParkingLot(5,4);
        parkingLotList_2.add(parkingLot_21);
        parkingLotList_2.add(parkingLot_22);
        parkingBoy_21 = new ParkingBoy(new NormalBoy(),parkingLotList_2);
        parkingBoy_22 = new ParkingBoy(new CompareBoy(),parkingLotList_2);
        parkingBoy_23 = new ParkingBoy(new CalculateBoy(),parkingLotList_2);
        parkingBoyList_2.add(parkingBoy_21);
        parkingBoyList_2.add(parkingBoy_22);
        parkingBoyList_2.add(parkingBoy_23);
        manager_2 = new Manager(parkingBoyList_2);

        managerList.add(manager_1);
        managerList.add(manager_2);


        superManager = new Manager(managerList);
    }

    @Test
    public void shouldParkCar() throws Exception {
        ParkTicket parkTicket = superManager.DoPark(car);
        assertNotNull(parkTicket);
    }

    @Test
    public void shouldNotParkIfAllLotsFull() throws Exception {
        parkingLot_11.setPlaceNum(0);
        parkingLot_12.setPlaceNum(0);
        parkingLot_21.setPlaceNum(0);
        parkingLot_22.setPlaceNum(0);
        assertNull(superManager.DoPark(car));
    }

    @Test
    public void shouldUnParkCar() throws Exception {
        ParkTicket parkTicket = superManager.DoPark(car);
        Car outCar = superManager.unPark(parkTicket);
        assertThat(outCar.getCarNum(),is(parkTicket.getCarNum()));
    }

    @Test
    public void shouldNotUnParkIfItIsNotHere() throws Exception {
        assertNull(superManager.unPark(new ParkTicket("Q00",parkingLot_11.getParkingLotNum())));
    }

    @Test
    public void shouldReport() throws Exception {
        String result = superManager.report();
        assertThat(result,  is("ParkingManager\n"+
                               "--ParkingManager\n"+
                               "----ParkingManager\n"+
                               "------Parker\n"+
                               "--------ParkingLot(5/5)\n"+
                               "--------ParkingLot(5/5)\n"));
    }
}
