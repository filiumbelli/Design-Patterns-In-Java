public class DemoCopyConstructor {
    public static void main(String[] args) {
        Employee boby = new Employee("Boby",new Addres("JD street","NY","US"));
        Employee jade = new Employee(boby);
        jade.name="Jade";
        System.out.println(jade);
        System.out.println(boby);

    }
}

class Addres {
    public String streetAddress, city, country;
    public Addres(String streetAddress, String city, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
    }

    public Addres(Addres address) {
        this(address.streetAddress, address.city, address.country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}

class Employee {
    String name;
    Addres address;

    public Employee(String name, Addres address) {
        this.name = name;
        this.address = address;
    }

    public Employee(Employee employee) {
        name = employee.name;
        address = new Addres(employee.address);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
