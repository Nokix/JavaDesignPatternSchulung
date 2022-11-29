package prototype.java_interface;

public class TopClass implements Cloneable{
    private int x;
    private InnerClass innerClass;

    public TopClass(int x, InnerClass innerClass) {
        this.x = x;
        this.innerClass = innerClass;
    }

    @Override
    public String toString() {
        return "TopClass{" +
                "x=" + x +
                ", innerClass=" + innerClass +
                '}';
    }

    @Override
    public TopClass clone() {
        try {
            TopClass clone = (TopClass) super.clone();
            //
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
