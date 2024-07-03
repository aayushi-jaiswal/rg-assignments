public class aayushiSingleton {

    private aayushiSingleton() {
        // Initialize any resources here
    }
    private static class SingletonHelper {
        private static final aayushiSingleton INSTANCE = new aayushiSingleton();
    }

    public static aayushiSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void showMessage() {
        System.out.println("Hello World! This is us checking Singleton Design Pattern");
    }

    public static void main(String[] args) {
        aayushiSingleton singleton = aayushiSingleton.getInstance();

        singleton.showMessage();
    }
}

