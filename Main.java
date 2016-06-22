package test.mayuresh;

import java.io.*;

public class Main {

    ParkingLot parkingLot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = getReader(args);
        Main main = new Main();
        String line = br.readLine();
        String[] data = line.split("\\s");
        Command command = new Command();
        while (line!=null) {
            data = line.split("\\s");
            int order = command.decipher(data[0]);
            switch (order) {
                case Command.CREATE_PARKING_LOT:
                    System.out.println(main.createParkingLot(Integer.parseInt(data[1])));
                    break;
                case Command.PARK:
                    System.out.println(main.addCar(data[1] + " " +data[2]));
                    break;
                case Command.LEAVE:
                    System.out.println(main.leaveCar(Integer.parseInt(data[1])));
                    break;
                case Command.STATUS:
                    System.out.println(main.status());
                    break;
                case Command.REGISTRATION_NUMBER_OF_CARS_WITH_COLOR:
                    System.out.println(main.findRegistrationNumberOfCarsWithColour(data[1]));
                    break;
                case Command.SLOT_NUMBER_OF_CARS_WITH_COLOR:
                    System.out.println(main.findSlotNumberOfCarsWithColour(data[1]));
                    break;
                case Command.SLOT_NUMBER_OF_CARS_WITH_REGISTRATION:
                    System.out.println(main.findSlotNumberOfCarsWithRegistrationNumber(data[1]));
                    break;
                case Command.UNKOWN:
                    break;
            }
            line = br.readLine();
            System.out.println();
        }
        br.close();
    }

    private static BufferedReader getReader(String[] args) {
        InputStreamReader ip = new InputStreamReader(System.in);
        if (args.length >= 1) {
            try {
                File f = new File(args[0]);
                ip = new InputStreamReader(new FileInputStream(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        BufferedReader br = new BufferedReader(ip);
        return br;
    }

    public String createParkingLot(int slots) {
        parkingLot = new ParkingLot(slots);
        return "Created a parking lot with " + slots + " slots";
    }

    public String addCar(String s) {
        String[] inp = s.split("\\s");
        int indexAlloted = parkingLot.addCar(new Car(inp[0], inp[1]));

        return (indexAlloted == -1) ? "Sorry, parking lot is full" : "Allocated slot number: " + indexAlloted;
    }

    public String leaveCar(int i) {
        parkingLot.leaveCar(i );
        return "Slot number " + i + " is free";
    }

    public String status() {
        StringBuilder status = new StringBuilder();
        status.append("Slot No.  Registration No Colour \n");
        status.append(parkingLot.status());
        return status.toString();
    }

    public String findRegistrationNumberOfCarsWithColour(String color) {
        return parkingLot.findRegOfCarWithColor(color);
    }

    public String findSlotNumberOfCarsWithRegistrationNumber(String registrationNumber) {
        return parkingLot.findSlotNumberOfCarWithRegistrationNumber(registrationNumber);

    }

    public String findSlotNumberOfCarsWithColour(String color) {
        return parkingLot.findSlotWithCarColor(color);
    }
}
