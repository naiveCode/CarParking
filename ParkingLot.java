package test.mayuresh;

import java.util.ArrayList;

/**
 * Created by naiveCode on 22/6/16.
 */
public class ParkingLot {
    ArrayList<ParkingSlot> slots;
    int slotsAvailable;

    ParkingLot(int num) {
        slots = new ArrayList<>();
        slotsAvailable = num;
        for (int i = 0; i < num; i++) {
            slots.add(new ParkingSlot(i, true));
        }
    }

    public int addCar(Car c) {
        for (int i = 0; i < slotsAvailable; i++) {
            if (slots.get(i).getVacancy()) {
                slots.get(i).setCar(c);
                slots.get(i).setVacancy(false);
                slotsAvailable--;
                return (i + 1);
            }
        }
        return -1;
    }

    public void leaveCar(int i) {
        slots.get(i).setVacancy(true);
        slotsAvailable++;
    }

    public String status() {
        StringBuilder s = new StringBuilder();
        int index = 1;
        for (int i = 0; i < slotsAvailable; i++) {
            if (!slots.get(i).getVacancy()) {
                Car c = slots.get(i).getCar();
                s.append(index + "  " + c.registrationNo + "    " + c.color + "\n");
                index++;
            }
        }
        return s.toString();

    }
}
