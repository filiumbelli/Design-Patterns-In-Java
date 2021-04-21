public class Demo1 {
    public static void main(String[] args) {
        Car ahmed = new CarProxy(new Driver("Ahmed", 16));
        ahmed.drive();
    }
}

interface Drivable {
    void drive();
}


class Driver {
    public String name;
    public int age;


    public Driver(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

class Car implements Drivable {

    protected Driver driver;

    public Car(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void drive() {
        System.out.println("Car is being driven by " + driver);
    }
}

class CarProxy extends Car {
    public CarProxy(Driver driver) {
        super(driver);
    }

    @Override
    public void drive() {
        if (driver.age >= 18) {
            super.drive();
        } else {
            System.out.println("Age restriction..");
        }
    }
}
