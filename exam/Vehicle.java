//Julia Vieira Dal Maso Jardim
//i6289351
//Exercise 4
import java.util.Map;

public interface Vehicle {

    //Sets method to return license plate
    public String getLicensePlate();

    //Sets method to return if OffroadCapable
    boolean isOffroadCapable();

    //Sets method to return fuel type
    String fuelType();

    //Prints vehicle details in vehicle registry
    static void printVehicleDetails(Map<String, Vehicle> vehicles) {
        System.out.println();
        System.out.println("Vehicle Registry contains:");
        for (Vehicle vehicle : vehicles.values()) {
            System.out.println(vehicle);
        }
    }
}
