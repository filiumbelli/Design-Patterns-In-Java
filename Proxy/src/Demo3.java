interface Human{
    void walk();
    void talk();
}
class Person implements  Human{
    @Override
    public void walk() {
        System.out.println("Walking");
    }

    public Person() {

    }

    @Override
    public void talk() {
        System.out.println("Bla bla ");
    }
}
public class Demo3 {
    public static void main(String[] args) {

    }
}

