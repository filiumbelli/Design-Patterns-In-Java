import java.io.*;

public class Demo1 {

    static void saveToFile(BasicSingleton singleton, String filename)
            throws Exception {
        try (
                FileOutputStream fileO = new FileOutputStream(filename);
                ObjectOutputStream out=new ObjectOutputStream(fileO))
        {
            out.writeObject(singleton);
        }
    }
    static BasicSingleton readFromFile(String filename) throws Exception {
        try(FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn))
        {
            return (BasicSingleton)in.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(111);

        String filename = "singleton.bin";
        saveToFile(singleton,filename);
        singleton.setValue(222);
        BasicSingleton singleton2 = readFromFile(filename);
        System.out.println(singleton.getValue());
        System.out.println(singleton2.getValue());
    }
}

// Problems that might happen on the application of singleton pattern
// 1.Reflection can break the code easily
// 2.Serialization
class BasicSingleton implements Serializable {
    private static BasicSingleton singleton;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private BasicSingleton() {
    }

    public static BasicSingleton getInstance() {
        if (singleton == null) {
            singleton = new BasicSingleton();
        }
        return singleton;
    }
    @Serial
    protected Object readResolve()
    {
        return singleton;
    }
}

