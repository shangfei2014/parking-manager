import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CalculateBoyTest {
    private Car car;
    private ParkingLot parkingLot_1;
    private ParkingLot parkingLot_2;
    private List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
    private ParkingService parkingBoy;

    @Before
    public void setUp() throws Exception {
        car = new Car("B78");
        parkingLot_1 = new ParkingLot(5,1);
        parkingLot_2 = new ParkingLot(8,2);
        parkingLotList.add(parkingLot_1);
        parkingLotList.add(parkingLot_2);
        parkingBoy = new ParkingBoy(new CalculateBoy(),parkingLotList);
    }

    @Test
    public void shouldParkCarInLotWithAHigherRate() throws Exception {
        parkingLot_1.setPlaceNum(2);
        parkingLot_2.setPlaceNum(2);
        ParkTicket parkTicket = parkingBoy.DoPark(car);
        assertThat(parkTicket.getParkLot(),is(1));
    }

    @Test
    public void shouldUnParkCarSuccessfully() throws Exception {
        ParkTicket parkTicket = parkingBoy.DoPark(car);
        Car outCar = parkingBoy.unPark(parkTicket);
        assertThat(outCar,is(car));
    }
}
