import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CompareBoyTest {
    private Car car;
    private ParkingLot parkingLot_1;
    private ParkingLot parkingLot_2;
    private List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
    private ParkingService parkingBoy;

    @Before
    public void setUp() throws Exception {
        car = new Car("A12");
        parkingLot_1 = new ParkingLot(5,1);
        parkingLot_2 = new ParkingLot(4,2);
        parkingLotList.add(parkingLot_1);
        parkingLotList.add(parkingLot_2);
        parkingBoy = new ParkingBoy(new CompareBoy(),parkingLotList);

    }

    @Test
    public void shouldParkInLotWithMoreSpace() throws Exception {
        ParkTicket parkTicket = parkingBoy.DoPark(car);
        assertThat(parkTicket.getParkLot(),is(1));
    }

    @Test
    public void shouldUnParkSuccessfully() throws Exception {
        ParkTicket parkTicket = parkingBoy.DoPark(car);
        Car outCar = parkingBoy.unPark(parkTicket);
        assertThat(outCar,is(car));
    }
}
