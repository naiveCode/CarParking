package test.mayuresh;

//Not a very good implementation
public class Command {
    static final int CREATE_PARKING_LOT = 0;
    static final int PARK = 1;
    static final int LEAVE = 2;
    static final int STATUS = 3;
    static final int REGISTRATION_NUMBER_OF_CARS_WITH_COLOR = 4;
    static final int SLOT_NUMBER_OF_CARS_WITH_COLOR = 5;
    static final int SLOT_NUMBER_OF_CARS_WITH_REGISTRATION = 6;
    static final int UNKOWN = -1;


    public int decipher(String s) {
        if (s.contentEquals("create_parking_lot")) {
            return CREATE_PARKING_LOT;
        } else if (s.contentEquals("park")) {
            return PARK;
        } else if (s.contentEquals("leave")) {
            return LEAVE;
        } else if (s.contentEquals("status")) {
            return STATUS;
        } else if (s.contentEquals("registration_numbers_for_cars_with_colour")) {
            return REGISTRATION_NUMBER_OF_CARS_WITH_COLOR;
        } else if (s.contentEquals("slot_numbers_for_cars_with_colour")) {
            return SLOT_NUMBER_OF_CARS_WITH_COLOR;
        } else if (s.contentEquals("slot_number_for_registration_number")) {
            return SLOT_NUMBER_OF_CARS_WITH_REGISTRATION;
        } else {
            return UNKOWN;
        }
    }
}
