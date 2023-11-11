//Alicia del Prado Rebordinos - 6295981 - Exercise4
public class Motorcycle extends AbstractVehicle{
    public Motorcycle(String license){
        super(license);
    }
    public String getLicensePlate(){
        return license;
    }
    public boolean isOffRoadCapable(){
        return true;
    }
    public String fuelType(){
        return "gasoline";
    }
}
