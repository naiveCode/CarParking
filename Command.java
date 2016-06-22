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
        if (s.startsWith("c")) {
            return CREATE_PARKING_LOT;
        } else if (s.startsWith("p")) {
            return PARK;
        } else if (s.startsWith("l")) {
            return LEAVE;
        } else if (s.startsWith("st")) {
            return STATUS;
        } else if (s.startsWith("re")) {
            return REGISTRATION_NUMBER_OF_CARS_WITH_COLOR;
        } else if (s.startsWith("sl") && s.endsWith("r")) {
            return SLOT_NUMBER_OF_CARS_WITH_COLOR;
        } else if (s.startsWith("sl") && s.endsWith("n")) {
            return SLOT_NUMBER_OF_CARS_WITH_REGISTRATION;
        } else {
            return UNKOWN;
        }
    }
}
