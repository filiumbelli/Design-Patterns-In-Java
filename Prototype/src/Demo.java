import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person adamSandler = new Person(new String[]{"Adam", "Sandler"},
                new Address("America", 15));
        Person bobyDixon = (Person) adamSandler.clone();
        bobyDixon.names = new String[]{"boby", "dixon"};
        bobyDixon.address.houseNumber = 16;
        System.out.println(adamSandler);
        System.out.println(bobyDixon);

    }
}


class Address implements Cloneable {
    public String streetName;
    public int houseNumber;

    public Address(String streetName, int houseNumber) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }

    // Deep Copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Address(streetName,houseNumber);
    }
}

class Person implements Cloneable{
    public String[] names;
    public Address address;

    public Person(String[] names, Address address) {
        this.names = names;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + Arrays.toString(names) +
                ", address=" + address +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Person(names.clone(), (Address) address.clone());
    }
}
