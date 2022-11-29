package composite;

public class Demo {
    public static void main(String[] args) {
        Term one = new Number(1);
        Term two = new Number(2);
        Term three = new Number(3);
        Term one_plus_three = new Add(one, three);
        Term finalterm = new Substract(one_plus_three, two);
        System.out.println(finalterm.evaluate());
    }
}
