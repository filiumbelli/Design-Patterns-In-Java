import java.util.HashMap;

public class Demo7 {
    public static void main(String[] args) {
        Printer main = Printer.get(Printer.Subsystem.PRIMARY);
        Printer aux1 = Printer.get(Printer.Subsystem.AUXILIARY);
        Printer aux2 = Printer.get(Printer.Subsystem.AUXILIARY);
        Printer fallback = Printer.get(Printer.Subsystem.FALLBACK);



    }
}


// Multiton pattern

class Printer {
    private static int instanceCount = 0;

    private Printer() {
        instanceCount++;
        System.out.println("Total: " + instanceCount);
    }

    enum Subsystem {
        PRIMARY,
        AUXILIARY,
        FALLBACK
    }

    private static HashMap<Subsystem, Printer>
            instances = new HashMap<>();

    public static Printer get(Subsystem subsystem) {
        if (instances.containsKey(subsystem))
            return instances.get(subsystem);
        Printer printer = new Printer();
        instances.put(subsystem, printer);
        return printer;
    }
}
