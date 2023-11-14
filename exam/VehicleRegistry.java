//Julia Vieira Dal Maso Jardim
//i6289351
//Exercise 4
import java.util.HashMap;
import java.util.Map;

public class VehicleRegistry {

    //Creates new vehicle registry
    private Map<String, Vehicle> vehicleRegistry;

    public VehicleRegistry() { //Constructor, creates Vehicle Registry HashMap
        this.vehicleRegistry = new HashMap<>();
    }


    //Adds new vehicle to registry
    public void add(Vehicle vehicle) {

        //Exception handlers
        if (vehicle.getLicensePlate() == null) { //Returns error if license plate is null
            throw new NullPointerException("License plate cannot be null.");
        }

        if (vehicle.getLicensePlate().isEmpty()) { //Returns error if license plate is empty
            throw new IllegalArgumentException("License plate cannot be empty.");
        }

        vehicleRegistry.put(vehicle.getLicensePlate(), vehicle); // Adds the vehicle to the registry with the licenseplate as key and the vehicle as a value
    }

    public Map<String, Vehicle> getAllVehicles() { //Returns vehicle registry map
        return vehicleRegistry;
    }


    public Vehicle get(String licensePlate){ //Returns vehicle with this licenseplate
        return vehicleRegistry.get(licensePlate);
    }

}
