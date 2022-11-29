package singleton;

import java.io.Serializable;

public class SimpleSingleton implements Serializable {
    public static SimpleSingleton INSTANCE = new SimpleSingleton();

    String message = "leer";

    private SimpleSingleton() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}
