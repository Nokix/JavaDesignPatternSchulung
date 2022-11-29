package prototype.own_interface;

public class InnerClass implements Prototype{
    private int y;
    private String str;

    public InnerClass(int y, String str) {
        this.y = y;
        this.str = str;
    }

    public InnerClass(InnerClass vorlage) {
        this.y = vorlage.y;
        this.str = vorlage.str;
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
        return new InnerClass(this);
    }
}
