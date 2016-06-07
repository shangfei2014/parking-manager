import java.util.List;
class CalculateBoy implements Choose {

    public ParkingLot chooseLot(List<ParkingLot> parkingLotList) {
        ParkingLot saveParkingLot = parkingLotList.get(0);
        for (ParkingLot parkingLot : parkingLotList) {
            double save_rate = saveParkingLot.getPlaceNum() / saveParkingLot.getOriginalNum();
            double rate = parkingLot.getPlaceNum() / parkingLot.getOriginalNum();
            if (rate < save_rate)
            { saveParkingLot = parkingLot;}
        }
        return saveParkingLot;
    }
}
