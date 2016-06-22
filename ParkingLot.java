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
            slots.add(new ParkingSlot(i+1, true));
        }
    }

    public int addCar(Car c) {
        for (int i = 0; i < slots.size(); i++) {
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
        for (int i = 0; i < slots.size() ; i++) {
            if (!slots.get(i).getVacancy()) {
                Car c = slots.get(i).getCar();
                s.append(index + "  " + c.registrationNo + "    " + c.color + "\n");
                index++;
            }
        }
        return s.toString();

    }

    public String findRegOfCarWithColor(String color) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < slots.size(); i++) {
            if (!slots.get(i).getVacancy() && slots.get(i).getCar().color.contentEquals(color)) {
                s.append(slots.get(i).getCar().registrationNo + ", ");

            }
        }
        if(s.length()==0){
            return "Not found";
        }
        return s.substring(0, s.length() - 2);
    }

    public String findCarWithRegistrationNumber(String registrationNumber) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < slots.size(); i++) {
            if (!slots.get(i).getVacancy() && slots.get(i).getCar().registrationNo.contentEquals(registrationNumber)) {
                s.append(i+1);

            }
        }
        if(s.length()==0){
            return "Not found";
        }
        return s.toString();
    }

    public String findSlotWithCarColor(String color) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < slots.size(); i++) {
            if (!slots.get(i).getVacancy() && slots.get(i).getCar().color.contentEquals(color)) {
                s.append((i+1) + ", ");

            }
        }
        if(s.length()==0){
            return "Not found";
        }
        return s.substring(0, s.length() - 2);
    }
}
