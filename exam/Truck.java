//Alicia del Prado Rebordinos - 6295981 - Exercise4
public class Truck extends Car{
    //Additional field for maximum payload weight.
    double maxLoadWeight;
    //Constructor to set the license and maximum load weight.
    public Truck(String license, double maxLoadWeight){
        super(license);
        this.maxLoadWeight = maxLoadWeight;
    }
    /*
    A method which determines if the truck can carry a given weight.
    This is, if the weight is equal or smaller than the maximum load weight.
     */
    public boolean canCarry(int weight) {
        if (weight <= maxLoadWeight) {
            return true;
        } else {
            return false;
        }
    }
    public String fuelType(){
        return "diesel";
    }
    }
