import java.io.File;

public class Demo2 {
}


class StaticBlockSingleton {
    private StaticBlockSingleton() throws Exception {
        System.out.println("Singleton is initializing");
        File.createTempFile(".", ".");
    }

    private static StaticBlockSingleton instance;

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            System.err.println("Failed to create singleton");
            e.printStackTrace();
        }
    }
    public static StaticBlockSingleton getInstance()
    {
        return instance;
    }
}
