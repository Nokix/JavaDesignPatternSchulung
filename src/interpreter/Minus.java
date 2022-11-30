package interpreter;

public class Minus implements Expression {
    private Expression a;

    public Minus(Expression a) {
        this.a = a;
    }

    public Expression getA() {
        return a;
    }

    @Override
    public <R> R inteprete(Interpreter<R> interpreter) {
        return interpreter.interprete(this);
    }

}
