package singleton;

public enum EnumSingleton {
    INSTANCE, SECOND;

    String message = "";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
