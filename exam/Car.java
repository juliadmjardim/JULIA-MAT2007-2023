//Alicia del Prado Rebordinos - 6295981 - Exercise4
public class Car extends AbstractVehicle{
    /*
    Constructor to set the license plate.
    Calls the constructor in ths super class 'AbstractVehicle'.
     */
    public Car(String license){
        super(license);
    }
    //Implement all methods from the Vehicle interface.
    public String getLicensePlate(){
        return license;
    }
    public boolean isOffRoadCapable(){
        return false;
    }
    public String fuelType(){
        return "gasoline";
    }
}
