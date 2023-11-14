//Julia Vieira Dal Maso Jardim
//i6289351
//Exercise 4
public class Motorcycle extends AbstractVehicle{

    //Constructor, extends licensePlate implementation from AbstractVehicle
    public Motorcycle(String licensePlate) {
        super(licensePlate);
    }

    //Overrides default setting of isOffroadCapable (false), setting it to true
    @Override
    public boolean isOffroadCapable() {
        return true;
    }
}
