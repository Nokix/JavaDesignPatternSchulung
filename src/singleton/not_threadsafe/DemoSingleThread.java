package singleton.not_threadsafe;

public class DemoSingleThread {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance("Hallo");
        System.out.println(singleton.getValue());
        Singleton singleton2 = Singleton.getInstance("Moin");
        System.out.println(singleton2.getValue());
    }
}
