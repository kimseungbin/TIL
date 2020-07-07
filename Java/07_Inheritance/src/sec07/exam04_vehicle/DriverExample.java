package io.wisoft.java_seminar.chap07.sec07.exam04_vehicle;

public class DriverExample {

    public static void main(String[] args) {
        Driver driver = new Driver();

        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        driver.drive(bus);
        driver.drive(taxi);
    }

}
