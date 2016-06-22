package test.mayuresh;

import java.util.ArrayList;

/**
 * Created by naiveCode on 22/6/16.
 */
public class ParkingLot {
    ArrayList<ParkingSlot> slots;
    int slotsAvailable;
    private int size;

    ParkingLot(int num) {
        slots = new ArrayList<>();
        slotsAvailable = num;
        size = num;
        for (int i = 0; i <= num; i++) {
            slots.add(new ParkingSlot(i , true));
        }
    }

    public int addCar(Car c) {
        for (int i = 1; i <= size; i++) {
            if (slots.get(i).getVacancy()) {
                slots.get(i).setCar(c);
                slots.get(i).setVacancy(false);
                slotsAvailable--;
                return i;
            }
        }
        return -1;
    }

    public void leaveCar(int i) {
        if(!slots.get(i).getVacancy()) {
            slots.get(i).setVacancy(true);
            slotsAvailable++;
        }else {
            System.out.println("No such car with index " + i);
        }
    }

    public String status() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (!slots.get(i).getVacancy()) {
                Car c = slots.get(i).getCar();
                s.append((i) + "  " + c.registrationNo + "    " + c.color + "\n");

            }
        }
        return s.substring(0,s.length()-1);

    }

    public String findRegOfCarWithColor(String color) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (!slots.get(i).getVacancy() && slots.get(i).getCar().color.contentEquals(color)) {
                s.append(slots.get(i).getCar().registrationNo + ", ");

            }
        }
        if (s.length() == 0) {
            return "Not found";
        }
        return s.substring(0, s.length() - 2);
    }

    public String findSlotNumberOfCarWithRegistrationNumber(String registrationNumber) {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            if (!slots.get(i).getVacancy() &&
                    slots.get(i).getCar().registrationNo.contentEquals(registrationNumber)) {
                s.append(i);
                break;
            }
        }
        if (s.length() == 0) {
            return "Not found";
        }
        return s.toString();
    }

    public String findSlotWithCarColor(String color) {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            if (!slots.get(i).getVacancy() && slots.get(i).getCar().color.contentEquals(color)) {
                s.append((i) + ", ");

            }
        }
        if (s.length() == 0) {
            return "Not found";
        }
        return s.substring(0, s.length() - 2);
    }
}
