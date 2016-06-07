import java.util.List;

public class Manager implements ParkingService{
    private final List<ParkingService> parkingBoyList;

    public Manager(List<ParkingService> parkingBoyList) {
        this.parkingBoyList = parkingBoyList;
    }

    public ParkTicket DoPark(Car car) {
        ParkTicket parkTicket = null;
        for (ParkingService parkingBoy : parkingBoyList) {
            parkTicket = parkingBoy.DoPark(car);
            if(parkTicket != null) break;
        }
        return parkTicket;
    }

    public Car unPark(ParkTicket parkTicket) {
        Car outCar = null;
        for (ParkingService parkingBoy : parkingBoyList) {
            outCar = parkingBoy.unPark(parkTicket);
            if (outCar != null) break;
        }
        return outCar;
    }

    @Override
    public String report() {
        return null;
    }
}

