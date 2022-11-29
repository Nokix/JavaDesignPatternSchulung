package prototype.java_interface;

public class Demo {
    public static void main(String[] args) {
        InnerClass innen = new InnerClass(3, "innen");
        TopClass orginal = new TopClass(10, innen);

        TopClass copy = orginal.clone();
        System.out.println("Orginal: " + orginal);
        System.out.println("Kopie: " + copy);

        innen.setY(4);
        innen.setStr("hallo");
        System.out.println("Orginal: " + orginal);
        System.out.println("Kopie: " + copy);
    }
}
