import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ParkingBoyTest {
    private Car car;
    private ParkingService parkingBoy;
    private ParkingLot parkingLot_1;
    private ParkingLot parkingLot_2;
    private List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();

    @Before
    public void setUp() throws Exception {
        car = new Car("B11");
        parkingLot_1 = new ParkingLot(5,1);
        parkingLot_2 = new ParkingLot(5,2);
        parkingLotList.add(parkingLot_1);
        parkingLotList.add(parkingLot_2);
        parkingBoy = new ParkingBoy(new NormalBoy(), parkingLotList);

    }

    @Test
    public void shouldParkCarWhenTwoParkingLotIsNotFull() throws Exception {
        ParkTicket parkTicket = parkingBoy.DoPark(car);
        assertNotNull(parkTicket);
        assertThat(parkTicket, is(new ParkTicket("B11", 1)));

    }

    @Test
    public void shouldParkInParkingLot2WhenParkingLot1IsFull() throws Exception {
        parkingLot_1.setPlaceNum(0);
        ParkTicket parkTicket = parkingBoy.DoPark(car);
        assertThat(parkTicket.getParkLot(),is(parkingLot_2.getParkingLotNum()));
    }

    @Test
    public void shouldCanNotParkWhenTwoParkingLotIsFull() throws Exception {
        parkingLot_1.setPlaceNum(0);
        parkingLot_2.setPlaceNum(0);
        ParkTicket parkTicket = parkingBoy.DoPark(car);
        assertNull(parkTicket);
    }

    @Test
    public void shouldUnParkWhenCarIsHere() throws Exception {
        ParkTicket parkTicket = parkingBoy.DoPark(car);
        Car outCar = parkingBoy.unPark(parkTicket);
        assertThat(outCar,is(car));
    }

    @Test
    public void shouldNotUnParkCarIfItIsNotHere() throws Exception {
        assertNull(parkingBoy.unPark(new ParkTicket("A00", 1)));
    }
}
