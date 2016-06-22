package test.mayuresh;

/**
 * Created by naiveCode on 22/6/16.
 */
public class ParkingSlot {
    private int index;
    private boolean isVacant;
    private Car car;

    ParkingSlot(int i, boolean isE) {
        index = i;
        isVacant = isE;
    }

    public void setVacancy(boolean vacancy) {
        isVacant = vacancy;
    }

    public boolean getVacancy() {
        return isVacant;
    }

    public void setCar(Car c) {
        car = c;
    }

    public Car getCar() {
        return car;
    }
}
