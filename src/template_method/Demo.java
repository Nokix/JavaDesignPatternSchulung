package template_method;

import template_method.letter.Customer;
import template_method.letter.PayUsBackLetter;

public class Demo {
    public static void main(String[] args) {
        Customer customer = new Customer(-300, "Viktor Reichert", "zu Hause");

        System.out.println(new PayUsBackLetter(customer).create());
    }
}
