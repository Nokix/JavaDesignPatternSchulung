package interpreter;

import java.util.Map;

public class IntegerIntepreter implements Interpreter<Integer>{
    Map<String, Integer> variables;

    public IntegerIntepreter(Map<String, Integer> variables) {
        this.variables = variables;
    }

    @Override
    public Integer interprete(Node node) {
        return variables.get(node.getValue());
    }

    @Override
    public Integer interprete(Add add) {
        return add.getA().inteprete(this) + add.getB().inteprete(this);
    }

    @Override
    public Integer interprete(Multiply multiply) {
        return multiply.getA().inteprete(this) * multiply.getB().inteprete(this);
    }

    @Override
    public Integer interprete(Minus minus) {
        return -minus.getA().inteprete(this);
    }
}
