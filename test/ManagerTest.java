import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ManagerTest {
    private Car car;
    private ParkingLot parkingLot_1;
    private ParkingLot parkingLot_2;
    private List<ParkingLot> parkingLotList_1 = new ArrayList<ParkingLot>();
    private ParkingService parkingBoy_1;
    private ParkingService parkingBoy_2;
    private ParkingService parkingBoy_3;
    private List<ParkingService> parkingBoyList = new ArrayList<ParkingService>();
    private ParkingService manager;

    @Before
    public void setUp() throws Exception {
        car = new Car("Q1");
        parkingLot_1 = new ParkingLot(5,1);
        parkingLot_2 = new ParkingLot(5,2);
        parkingLotList_1.add(parkingLot_1);
        parkingLotList_1.add(parkingLot_2);
        parkingBoy_1 = new ParkingBoy(new NormalBoy(),parkingLotList_1);
        parkingBoy_2 = new ParkingBoy(new CompareBoy(),parkingLotList_1);
        parkingBoy_3 = new ParkingBoy(new CalculateBoy(),parkingLotList_1);
        parkingBoyList.add(parkingBoy_1);
        parkingBoyList.add(parkingBoy_2);
        parkingBoyList.add(parkingBoy_3);
        manager = new Manager(parkingBoyList);
    }

    @Test
    public void shouldParkCar() throws Exception {
        ParkTicket parkTicket = manager.DoPark(car);
        assertNotNull(parkTicket);
    }

    @Test
    public void shouldNotParkCarIfAllLotsAreFull() throws Exception {
        parkingLot_1.setPlaceNum(0);
        parkingLot_2.setPlaceNum(0);
        ParkTicket parkTicket = manager.DoPark(car);
        assertNull(parkTicket);
    }

    @Test
    public void shouldUnParkCar() throws Exception {
        ParkTicket parkTicket = manager.DoPark(car);
        Car outCar = manager.unPark(parkTicket);
        assertThat(outCar,is(car));
    }

    @Test
    public void shouldNotUnParkIfItIsNotHere() throws Exception {
        assertNull(manager.unPark(new ParkTicket("Q00",parkingLot_1.getParkingLotNum())));
    }
}
