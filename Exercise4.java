//Julia Vieira Dal Maso Jardim
//i6289351
//Exercise 4
public class Exercise4 {
    public static void main(String[] args) {
        // 1. Initialize the vehicle registry
        VehicleRegistry vr = new VehicleRegistry();

        // 2. Create and add different vehicles
        Car c1 = new Car("YJA-784");
        Motorcycle m1 = new Motorcycle("YJZ-321");
        Truck t1 = new Truck("DAF-111", 200); // Max load weight of 10,000 units
        vr.add(c1);
        vr.add(m1);
        vr.add(t1);

        // 3. Demonstrating Polymorphism
        Vehicle.printVehicleDetails(vr.getAllVehicles());

        // 4. Testing the truck’s ability to carry weight
        if (t1.canCarry(5000)) {
            System.out.println("The truck can carry 5000 units.");
        } else {
            System.out.println("The truck cannot carry 5000 units.");
        }
        if (t1.canCarry(199)) {
            System.out.println("The truck can carry 199 units.");
        } else {
            System.out.println("The truck cannot carry 199 units.");
        }

        // 5. Test efficiency
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            Car car = new Car("CAR-" + i);
            vr.add(car);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time taken to add 10000 cars: " + duration + " nanoseconds.");

        // 6. Robustness test
        try {Car carWithError = new Car(null);
            vr.add(carWithError);
            Car emptyCar = new Car("");
            vr.add(emptyCar);
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}