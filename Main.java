package test.mayuresh;

import java.io.*;

public class Main {

    ParkingLot parkingLot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = getReader(args);
        String[] data = br.readLine().split("\\s");
        while (data != null) {

        }

    }

    private static BufferedReader getReader(String[] args) {
        InputStreamReader ip = new InputStreamReader(System.in);
        if (args.length >= 1) {
            try {
                File f = new File(args[0]);
                System.out.println("reading input from " + f.getAbsolutePath());
                ip = new InputStreamReader(new FileInputStream(f));
            } catch (FileNotFoundException e) {
                System.out.println("No such file found");
                e.printStackTrace();
            }
        } else {
            System.out.println("Read i/p from console");
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

        return (indexAlloted==-1)?"Sorry, parking lot is full":"Allocated slot number: " + indexAlloted;
    }

    public String leaveCar(int i) {
        parkingLot.leaveCar(i-1);
        return "Slot number " + i + " is free";
    }

    public String status() {
        StringBuilder status = new StringBuilder();
        status.append("Slot No.  Registration No Colour \n");
        status.append(parkingLot.status());
        return status.toString();
    }
}
