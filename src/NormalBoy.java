import java.util.List;

public class NormalBoy implements Choose{
    public ParkingLot chooseLot(List<ParkingLot> parkingLotList) {
        ParkingLot ableParkingLot = parkingLotList.get(0);
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getPlaceNum() > 0) {
                ableParkingLot = parkingLot;
                break;
            }
        }
        return ableParkingLot;
    }
}
