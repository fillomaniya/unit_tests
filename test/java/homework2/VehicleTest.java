package homework2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    public void testCarInstanceVehicle() {
        Car car = new Car("BMW", "M5", 2020);
        assertInstanceOf(Vehicle.class, car);
    }

    @Test
    public void testCarHasFourWheels() {
        Car car = new Car("BMW", "M5", 2020);
        assertEquals(4, car.getNumWheels());
    }

    @Test
    public void testBikeHasFourWheels() {
        Motorcycle bike = new Motorcycle("Honda", "CBR1000", 2020);
        assertEquals(2, bike.getNumWheels());
    }

    @Test
    public void testCarSpeed() {
        Car car = new Car("BMW", "M5", 2020);
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    @Test
    public void testBikeSpeed() {
        Motorcycle bike = new Motorcycle("Honda", "CBR1000", 2020);
        bike.testDrive();
        assertEquals(75, bike.getSpeed());
    }

    @Test
    public void testCarSpeedAfterStop() {
        Car car = new Car("BMW", "M5", 2020);
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }

    @Test
    public void testBikeSpeedAfterStop() {
        Motorcycle bike = new Motorcycle("Honda", "CBR1000", 2020);
        bike.testDrive();
        bike.park();
        assertEquals(0, bike.getSpeed());
    }
}