package interpreter;

public class Multiply implements Expression{
    Expression a;
    Expression b;

    public Multiply(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }

    public Expression getA() {
        return a;
    }

    public Expression getB() {
        return b;
    }

    @Override
    public <R> R inteprete(Interpreter<R> interpreter) {
        return interpreter.interprete(this);
    }

}
