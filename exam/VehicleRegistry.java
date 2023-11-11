//Alicia del Prado Rebordinos - 6295981 - Exercise4
import java.util.Map;
public class VehicleRegistry {
    /*
    Creates a map called registry that saves a string (the license) and a vehicle.
    By importing and making it a hashmap it's possible to save both the license and the vehicle linked together.
     */
    Map<String,Vehicle> registry = new java.util.HashMap<>();
    /*
    Add a vehicle.
    Adds it using the 'put' method to the map with the license linked to the vehicle by using the getLicensePlate() method.
     */
    public void add(Vehicle vehicle){
        registry.put(vehicle.getLicensePlate(), vehicle);
    }
    /*
    Retrieve a vehicle based on the license plate.
     */
    public Vehicle get(String license){
        return registry.get(license);
    }
    /*
    Retrieve all vehicles in the registry
    by defining the method as a map.
     */
    public Map<String,Vehicle> getAllVehicles(){
        return registry;
    }
}
