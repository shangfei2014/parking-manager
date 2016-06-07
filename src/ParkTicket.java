
public class ParkTicket {
    private String carNum;
    private int parkingLotNum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkTicket that = (ParkTicket) o;

        if (carNum != null ? !carNum.equals(that.carNum) : that.carNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return carNum != null ? carNum.hashCode() : 0;
    }

    public ParkTicket(String carNum, int parkingLotNum) {
        this.carNum = carNum;
        this.parkingLotNum = parkingLotNum;
    }

    public String getCarNum() {
        return carNum;
    }

    public int getParkLot() {
        return parkingLotNum;
    }
}
