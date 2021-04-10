public class Demo4 {
}

class InnerStaticSingleton {
    private InnerStaticSingleton() {
    }

    private static class Imp {
        private static final InnerStaticSingleton instance = new InnerStaticSingleton();

    }
    public InnerStaticSingleton getInstance() {
        return Imp.instance;
    }
}
