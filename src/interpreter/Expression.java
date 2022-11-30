package interpreter;

public interface Expression {
    <R> R inteprete(Interpreter<R> interpreter);
}
