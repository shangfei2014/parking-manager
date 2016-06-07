import java.util.List;
public class CompareBoy implements Choose {
    public ParkingLot chooseLot(List<ParkingLot> parkingLotList) {
        ParkingLot betterParkingLot = parkingLotList.get(0);
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getPlaceNum() > betterParkingLot.getPlaceNum())
            {
               betterParkingLot = parkingLot;
            }
        }
        return betterParkingLot;
    }
}
