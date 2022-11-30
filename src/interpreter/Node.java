package interpreter;

public class Node implements Expression{
    private String value;

    public Node(String value) {
        this.value = value;
    }

    @Override
    public <R> R inteprete(Interpreter<R> interpreter) {
        return interpreter.interprete(this);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                '}';
    }
}
