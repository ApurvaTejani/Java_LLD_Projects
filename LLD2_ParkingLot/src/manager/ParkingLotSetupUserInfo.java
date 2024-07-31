package manager;

import java.util.Scanner;

public class ParkingLotSetupUserInfo {
    private int NoOfParkingFloors;
    private int NoOfParkingSlots;

    private int noOfGates;

    public int getNoOfParkingFloors() {
        return NoOfParkingFloors;
    }

    public int getNoOfParkingSlots() {
        return NoOfParkingSlots;
    }

    public int getNoOfGates() {
        return noOfGates;
    }

    public void initializeSetup(Scanner sc){
        System.out.println("Enter how many parking floors you need: ");
         NoOfParkingFloors=sc.nextInt();
        System.out.println("Enter how many parking slots each parking floor has: ");
         NoOfParkingSlots=sc.nextInt();
        System.out.println("Enter number of Entry Gates");
         noOfGates= sc.nextInt();
    }
}
