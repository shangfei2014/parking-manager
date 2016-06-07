import java.util.List;

public class ParkingBoy implements ParkingService{
    private final Choose choose;
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(Choose choose, List<ParkingLot> parkingLotList) {
        this.choose = choose;
        this.parkingLotList = parkingLotList;
    }


    public ParkTicket DoPark(Car car) {
        ParkingLot ableParkingLot = choose.chooseLot(parkingLotList);
        return ableParkingLot.park(car);
    }



    public Car unPark(ParkTicket parkTicket) {
        ParkingLot saveParkingLot = parkingLotList.get(0);
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkTicket.getParkLot() == parkingLot.getParkingLotNum()) saveParkingLot = parkingLot;
            break;
        }
        return saveParkingLot.unPark(parkTicket);
    }

    @Override
    public String report() {
        return null;
    }

}
