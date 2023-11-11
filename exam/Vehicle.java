//Alicia del Prado Rebordinos - 6295981 - Exercise4
import java.util.Map;
public interface Vehicle {
    //Returns license plate of the vehicle.
    String getLicensePlate();
    //Returns true if the vehicle is off-road capable.
    boolean isOffRoadCapable();
    //Returns the type of fuel the vehicle uses.
    String fuelType();
    /*
    Prints the license number, if the vehicle is off-road capable and the fuel type.
    Opens a loop iterating through the details of vehicle.
    The details are obtained by calling the getter methods and saving the return as a variable.
     */
    static void printVehicleDetails(Map <String,Vehicle> Vehicles){
        for (Vehicle vehicle : Vehicles.values()){
            String license = vehicle.getLicensePlate();
            boolean capable = vehicle.isOffRoadCapable();
            String fuel = vehicle.fuelType();
            System.out.println("Vehicle license: "+license);
            System.out.println("Is the vehicle off-road capable?"+capable);
            System.out.println("Fuel type: "+fuel);
        }
    }
}
