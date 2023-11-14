//Julia Vieira Dal Maso Jardim
//i6289351
//Exercise 4
public class Truck extends Car{
    double maxLoadWeight;

    //Constructor, extends licensePlate implementation from Car
    public Truck(String licensePlate, double maxLoadWeight){
        super(licensePlate);
        this.maxLoadWeight=maxLoadWeight; //Adds maxLoadWeight argument
    }

    //Overrides standard "gasoline" fuel type from AbstractVehicle
    @Override
    public String fuelType(){
        return "diesel";
    }

    //Returns true if value given is possible to carry given maxLoadWeight
    boolean canCarry(int weight){
        if (weight<=maxLoadWeight){
            return true;
        } else {
            return false;
        }
    }
}
