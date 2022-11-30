package template_method.letter;

public class Customer {
    private int money;
    private String name;
    private String address;

    public Customer(int money, String name, String address) {
        this.money = money;
        this.name = name;
        this.address = address;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
