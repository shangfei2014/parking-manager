import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int placeNum;
    private List<Car> carList = new ArrayList<Car>();
    private int parkingLotNum;
    private int originalNum;

    public ParkingLot(int placeNum , int parkingLotNum) {
        this.placeNum = placeNum;
        this.parkingLotNum = parkingLotNum;
        this.originalNum = placeNum;
    }



    public ParkTicket park(Car car) {
        if (placeNum > 0 )
        {
            ParkTicket parkTicket = new ParkTicket(car.getCarNum(), parkingLotNum);
            carList.add(car);
            placeNum--;
            return parkTicket;
        }
        return null;
    }

    public int getPlaceNum() {
        return placeNum;
    }

    public void setPlaceNum(int placeNum) {
        this.placeNum = placeNum;
    }

    public Car unPark(ParkTicket parkTicket) {
        for (Car car : carList ) {
            if (parkTicket.getCarNum().equals(car.getCarNum())) {
                placeNum++;
                return car;
            }
        }
        return null;
    }


    public int getParkingLotNum() {
        return parkingLotNum;
    }

    public int getOriginalNum() {
        return originalNum;
    }
}
