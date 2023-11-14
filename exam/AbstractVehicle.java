//Julia Vieira Dal Maso Jardim
//i6289351
//Exercise 4
public abstract class AbstractVehicle implements Vehicle{

    String licensePlate;

    //Default constructor
    public AbstractVehicle(){
        this.licensePlate= "?";
    }

    //Constructor with specified licensePlate
    public AbstractVehicle(String licensePlate){
        this.licensePlate = licensePlate;
    }

    //Implements interface (Vehicle) getLicensePlate method, returning licensePlate
    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    //Implements interface (Vehicle) isOffroadCapable method, returning false as default
    @Override
    public boolean isOffroadCapable() {
        return false;
    }

    //Implements interface (Vehicle) fuelType method, returning "gasoline" as default
    @Override
    public String fuelType(){
        return "Gasoline";
    }

    //Overrides default method "toString "in String class, that would return memory location
        // Returns instead valuable informaiton about given vehivle
    @Override
    public String toString() {
        return "License Plate: " + licensePlate + ", Is the vehicle off-road capable? " + isOffroadCapable() + ", Fuel Type: " + fuelType();
    }
}
