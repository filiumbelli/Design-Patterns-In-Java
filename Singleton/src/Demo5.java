import java.io.*;

public class Demo5 {

    public static void main(String[] args) throws Exception {
        EnumBasedSingleton enumBasedSingleton = EnumBasedSingleton.INSTANCE;
        enumBasedSingleton.setValue(111);
        saveToFile(enumBasedSingleton,"enum.bin");
        EnumBasedSingleton enumBasedSingleton1 = EnumBasedSingleton.INSTANCE;
        enumBasedSingleton1.setValue(222);
        System.out.println(readFromFile("enum.bin").getValue());


    }



    static void saveToFile(EnumBasedSingleton singleton, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(singleton);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static EnumBasedSingleton readFromFile(String filename) throws Exception {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (EnumBasedSingleton) ois.readObject();
        }
    }
}


enum EnumBasedSingleton {
    INSTANCE;

    EnumBasedSingleton() {
        value = 42;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
