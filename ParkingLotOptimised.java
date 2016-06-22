package test.mayuresh;

import java.util.*;

/**
 * Created by naiveCode on 22/6/16.
 */
public class ParkingLotOptimised {
    /*
      Can use a min heap to store the slots which are not used
        use a hash map to store the registration number and slots as per the colour - HashMap<color,RegAndSlot>
        use a hashmap to store car with reg no
    */
    int slotsAvailable;
    MinHeap availableSlotsHeap;


    HashMap<String, RegistrationNumAnSlot> colorMap;
    HashMap<String, String> registrationMap;

    ArrayList<ParkingSlot> slots;


    ParkingLotOptimised(int num) {
        availableSlotsHeap = new MinHeap(num);
        slotsAvailable = num;
        colorMap = new HashMap<>();
        registrationMap = new HashMap<>();
        slots = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            slots.add(new ParkingSlot(i + 1, true));
        }
    }

    public int addCar(Car c) {
        int indexToInsert = availableSlotsHeap.extractMin();
        if (indexToInsert == -1) return -1;
        registrationMap.put(c.registrationNo, indexToInsert + "");
        slots.get(indexToInsert).setCar(c);
        slots.get(indexToInsert).setVacancy(false);
        if (colorMap.containsKey(c.color)) {
            RegistrationNumAnSlot t = colorMap.get(c.color);
            t.reg.add(c.registrationNo);
            t.slot.add(indexToInsert);
            colorMap.put(c.color, t);
        } else {

            RegistrationNumAnSlot t = new RegistrationNumAnSlot(c.registrationNo, indexToInsert);
            colorMap.put(c.color, t);
        }
        return indexToInsert;
    }

    public void leaveCar(int i) {

        slots.get(i).setVacancy(true);
        availableSlotsHeap.insert(i);
        Car c = slots.get(i).getCar();
        registrationMap.remove(c.registrationNo);
        String color = c.color;
        RegistrationNumAnSlot t = colorMap.get(color);
        t.slot.remove(i);
        t.reg.remove(c.registrationNo);
        colorMap.put(color, t);

    }

    public String status() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < slots.size(); i++) {
            if (!slots.get(i).getVacancy()) {
                Car c = slots.get(i).getCar();
                s.append((i) + "  " + c.registrationNo + "    " + c.color + "\n");

            }
        }
        return s.substring(0, s.length() - 1);
    }

    public String findRegOfCarWithColor(String color) {
        RegistrationNumAnSlot t = colorMap.get(color);
        StringBuilder s = new StringBuilder();
        Iterator<String> itr = t.reg.iterator();
        while (itr.hasNext()) {
            String l = itr.next();
            s.append(l + ", ");
        }
        if (s.length() == 0) {
            return "Not found";
        }
        return s.substring(0, s.length() - 2);
    }

    public String findSlotNumberOfCarWithRegistrationNumber(String registrationNumber) {
        if (registrationMap.containsKey(registrationNumber)) {
            return registrationMap.get(registrationNumber);
        }
        return "Not found";
    }

    public String findSlotWithCarColor(String color) {

        RegistrationNumAnSlot t = colorMap.get(color);
        StringBuilder s = new StringBuilder();
        Iterator<Integer> itr = t.slot.iterator();
        while (itr.hasNext()) {
            Integer l = itr.next();
            s.append(l + ", ");
        }
        if (s.length() == 0) {
            return "Not found";
        }
        return s.substring(0, s.length() - 2);
    }


    class RegistrationNumAnSlot {
        HashSet<String> reg;
        HashSet<Integer> slot;

        RegistrationNumAnSlot(String r, int s) {
            reg = new HashSet<>();
            reg.add(r);
            slot = new HashSet<>();
            slot.add(s);
        }

        public void add(String r, int s) {
            reg.add(r);
            slot.add(s);
        }

    }


}
