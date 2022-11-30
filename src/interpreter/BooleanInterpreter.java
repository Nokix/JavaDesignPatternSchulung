package interpreter;

import java.util.Map;

public class BooleanInterpreter implements Interpreter<Boolean>{
    Map<String, Boolean> variables;

    public BooleanInterpreter(Map<String, Boolean> variables) {
        this.variables = variables;
    }

    @Override
    public Boolean interprete(Node node) {
        return variables.get(node.getValue());
    }

    @Override
    public Boolean interprete(Add add) {
        return add.getA().inteprete(this) || add.getB().inteprete(this);
    }

    @Override
    public Boolean interprete(Multiply multiply) {
        return multiply.getA().inteprete(this) && multiply.getB().inteprete(this);
    }

    @Override
    public Boolean interprete(Minus minus) {
        return !minus.getA().inteprete(this);
    }
}
