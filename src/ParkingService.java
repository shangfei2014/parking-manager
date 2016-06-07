public interface ParkingService {
    ParkTicket DoPark(Car car);

    Car unPark(ParkTicket parkTicket);

    String report();
}
