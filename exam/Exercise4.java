import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

public class Exercise4Test {

    private VehicleRegistry registry;

    @Before
    public void setUp() {
        registry = new VehicleRegistry();
    }
    
    // Test for null license plate
    @Test(expected = IllegalArgumentException.class, timeout=200)
    public void testCarConstructorWithNullLicensePlate() {
        new Car(null);
    }

    // Test for empty license plate
    @Test(expected = IllegalArgumentException.class, timeout=200)
    public void testCarConstructorWithEmptyLicensePlate() {
        new Car("");
    }

    // Test that Car extends AbstractVehicle by verifying the behavior of the getLicensePlate() method
    @Test(timeout = 300)
    public void testCarInheritsAbstractVehicle() {
        String license = "YJZ 711";
        Car car = new Car(license);
        assertEquals(license, car.getLicensePlate());
    }


    // Test if Car implements all methods of Vehicle interface
    @Test(timeout = 300)
    public void testCarImplementsAllVehicleMethods() {
        Car car = new Car("YJZ 711");
        assertNotNull(car.getLicensePlate());  // Checking getLicensePlate
        assertNotNull(car.isOffroadCapable()); // Checking isOffroadCapable
        assertNotNull(car.fuelType());         // Checking fuelType
    }

    // Test if cars are not off-road capable
    @Test(timeout = 300)
    public void testCarIsNotOffroadCapable() {
        Car car = new Car("YJZ 711");
        assertFalse(car.isOffroadCapable());
    }

    // Test if cars use gasoline (or petrol)
    @Test(timeout = 300)
    public void testCarUsesGasoline() {
        Car car = new Car("YJZ 711");
	assertTrue("petrol".equalsIgnoreCase(car.fuelType()) || "gasoline".equalsIgnoreCase(car.fuelType()));
    }


   // Test Constructor Robustness for null input
    @Test(expected = IllegalArgumentException.class, timeout = 200)
    public void testConstructorWithNullLicensePlate() {
        new Motorcycle(null);
    }

    // Test Constructor Robustness for empty input
    @Test(expected = IllegalArgumentException.class, timeout = 200)
    public void testConstructorWithEmptyLicensePlate() {
        new Motorcycle("");
    }


    // Test if Motorcycle implements all methods of Vehicle interface
    @Test(timeout = 1000)
    public void testMotorcycleImplementsAllVehicleMethods() {
        Motorcycle motorcycle = new Motorcycle("ABC 123");
        assertNotNull(motorcycle.getLicensePlate());  // Checking getLicensePlate
        assertNotNull(motorcycle.isOffroadCapable()); // Checking isOffroadCapable
        assertNotNull(motorcycle.fuelType());         // Checking fuelType
    }

    // Test if motorcycles are off-road capable
    @Test(timeout = 200)
    public void testMotorcycleIsOffroadCapable() {
        Motorcycle motorcycle = new Motorcycle("ABC 123");
        assertTrue(motorcycle.isOffroadCapable());
    }

    // Test if motorcycles use gasoline (or petrol)
    @Test(timeout = 200)
    public void testMotorcycleUsesGasoline() {
        Motorcycle motorcycle = new Motorcycle("ABC 123");
	assertTrue("petrol".equalsIgnoreCase(motorcycle.fuelType()) || "gasoline".equalsIgnoreCase(motorcycle.fuelType()));
    }


    // Test Constructor Robustness for null input
    @Test(expected = IllegalArgumentException.class, timeout = 200)
    public void testTruckConstructorWithNullLicensePlate() {
        new Truck(null, 1000.0);
    }

    // Test Constructor Robustness for empty input
    @Test(expected = IllegalArgumentException.class, timeout = 200)
    public void testTruckConstructorWithEmptyLicensePlate() {
        new Truck("", 1000.0);
    }


    // Test if Truck implements all methods of Vehicle interface
    @Test(timeout = 300)
    public void testTruckImplementsAllVehicleMethods() {
        Truck truck = new Truck("ABC 123", 1000.0);
        assertNotNull(truck.getLicensePlate());  // Checking getLicensePlate
        assertNotNull(truck.isOffroadCapable()); // Checking isOffroadCapable
        assertNotNull(truck.fuelType());         // Checking fuelType
    }

    // Test if trucks are not off-road capable
    @Test(timeout = 300)
    public void testTruckIsNotOffroadCapable() {
        Truck truck = new Truck("ABC 123", 1000.0);
        assertFalse(truck.isOffroadCapable());
    }

    // Test if trucks use Diesel
    @Test(timeout = 300)
    public void testTruckUsesDiesel() {
        Truck truck = new Truck("ABC 123", 1000.0);
        assertTrue("Diesel".equalsIgnoreCase(truck.fuelType()));
    }

    // Test truck's carrying capacity
    @Test(timeout = 300)
    public void testCanCarryWeightWithinLimit() {
        Truck truck = new Truck("XYZ 456", 1500.0);
        assertTrue(truck.canCarry(1000));
    }

    @Test(timeout = 300)
    public void testCannotCarryWeightBeyondLimit() {
        Truck truck = new Truck("XYZ 456", 1500.0);
        assertFalse(truck.canCarry(2000));
    }


    // Test the robustness of the add method

    @Test(expected = IllegalArgumentException.class, timeout = 300)
    public void testAddNullVehicle() {
        registry.add(null);
    }

    @Test(expected = IllegalArgumentException.class, timeout = 300)
    public void testAddVehicleWithNullLicensePlate() {
        Vehicle vehicleWithNullLicense = new Car(null); // Assuming Car's constructor is still used for the example.
        registry.add(vehicleWithNullLicense);
    }

    @Test(timeout = 300)
    public void testAddValidVehicle() {
        Car validCar = new Car("ABC 123");
        registry.add(validCar);
        assertEquals(validCar, registry.get("ABC 123"));
    }

    // Test the robustness of the get method

    @Test(timeout = 300)
    public void testGetNonexistentVehicle() {
        assertNull(registry.get("XYZ 789"));
    }

    @Test(timeout = 300)
    public void testGetValidVehicle() {
        Car validCar = new Car("DEF 456");
        registry.add(validCar);
        assertEquals(validCar, registry.get("DEF 456"));
    }


}
