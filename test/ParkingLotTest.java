import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {

    private ParkingLot parkingLot;
    private Car car;
    int placeNum = 5;
    int parkingLotNum = 1;

    @Before
    public void setUp() throws Exception {
        car = new Car("A11");
        parkingLot = new ParkingLot(placeNum,parkingLotNum);
    }

    @Test
    public void shouldParkCar() throws Exception {
        ParkTicket parkTicket = parkingLot.park(car);
        assertNotNull(parkTicket);
    }

    @Test
    public void shouldParkCarWhenParkingLotIsNutFull() throws Exception {
        ParkTicket parkTicket = parkingLot.park(car);
        assertThat(parkTicket,is(new ParkTicket("A11", parkingLotNum)));
    }

    @Test
    public void shouldParkMoreTimes() throws Exception {
        Car car_1 = new Car("A12");
        parkingLot.park(car);
        parkingLot.park(car_1);
        assertThat(parkingLot.getPlaceNum(), is(placeNum - 2));
    }

    @Test
    public void shouldNotParkWhenParkingLotIsFull() throws Exception {
        parkingLot.setPlaceNum(0);
        ParkTicket parkTicket = parkingLot.park(car);
        assertNull(parkTicket);
    }

    @Test
    public void shouldUnParkCar() throws Exception {
        ParkTicket parkTicket = parkingLot.park(car);
        Car parkOutCar = parkingLot.unPark(parkTicket);
        assertThat(parkOutCar,is(car));
    }

    @Test
    public void shouldUnParkMoreCars() throws Exception {
        Car car_1 = new Car("A13");
        ParkTicket parkTicket = parkingLot.park(car);
        ParkTicket parkTicket_1 = parkingLot.park(car_1);
        parkingLot.unPark(parkTicket);
        parkingLot.unPark(parkTicket_1);
        assertThat(parkingLot.getPlaceNum(),is(placeNum));
    }

    @Test
    public void shouldNotUnPackCarWhenItIsNotThere() throws Exception {
        Car parkOutCar = parkingLot.unPark(new ParkTicket("A00", parkingLotNum));
        assertNull(parkOutCar);
    }
}
