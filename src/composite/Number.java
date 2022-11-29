package composite;

public class Number implements Term{
    private int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }
}
