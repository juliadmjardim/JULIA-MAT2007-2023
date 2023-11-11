//Alicia del Prado Rebordinos - 6295981 - Exercise4
public abstract class AbstractVehicle implements Vehicle{
    //String field for the license plate.
    String license = getLicensePlate();
    /*
    Constructor to set the license plate.
    If the license is null an error gets printed.
     */
    public AbstractVehicle(String license){
        if (license == null){
            System.out.println("An error ocurred: License plate cannot be null or empty.");
        }else{
            this.license=license;
        }
    }
    //Override the getter of the license plate.
    public String getLicensePlate(){
        return license;
    }
}
