package prototype.java_interface;

public class InnerClass {
    private int y;
    private String str;

    public InnerClass(int y, String str) {
        this.y = y;
        this.str = str;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "InnerClass{" +
                "y=" + y +
                ", str='" + str + '\'' +
                '}';
    }
}
