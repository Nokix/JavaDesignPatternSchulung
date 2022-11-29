package prototype.java_interface;

public class InnerClass implements Cloneable{
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

    @Override
    public InnerClass clone() {
        try {
            InnerClass clone = (InnerClass) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
