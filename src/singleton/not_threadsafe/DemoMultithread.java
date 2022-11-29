package singleton.not_threadsafe;

public class DemoMultithread {
    public static void main(String[] args) {
        new Thread(() -> {
            Singleton singleton = Singleton.getInstance("Hallo");
            System.out.println(singleton.getValue());
        }).start();

        new Thread(() -> {
            Singleton singleton = Singleton.getInstance("Moin");
            System.out.println(singleton.getValue());
        }).start();
    }
}
