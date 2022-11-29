package prototype.own_interface;

public class TopClass implements Prototype{
    private int x;
    private InnerClass innerClass;

    public TopClass(int x, InnerClass innerClass) {
        this.x = x;
        this.innerClass = innerClass;
    }

    public TopClass(TopClass vorlage) {
        this.x = vorlage.x;
        this.innerClass = new InnerClass(vorlage.innerClass);
    }

    @Override
    public TopClass clone() {
        return new TopClass(this);
    }

    @Override
    public String toString() {
        return "TopClass{" +
                "x=" + x +
                ", innerClass=" + innerClass +
                '}';
    }
}
