package singleton.not_threadsafe;

public class Singleton {
    private static Singleton instance;
    private String value;

    private Singleton(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.value = value;
    }

    public static synchronized Singleton getInstance(String value) {
//        Singleton result = instance;
//        if (instance != null) return result;
//        synchronized (Singleton.class) {
//            if (instance == null) instance = new Singleton(value);
//            return instance;
//        }
        if(instance == null) instance = new Singleton(value);
        return instance;
    }

    public String getValue() {
        return value;
    }
}
