package interpreter;

public interface Interpreter<R> {
    R interprete(Node node);

    R interprete(Add add);

    R interprete(Multiply multiply);

    R interprete(Minus minus);
}
