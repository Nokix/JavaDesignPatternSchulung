package interpreter;

import java.util.Map;

public class ReadableIntepreter implements Interpreter<String>{

    public ReadableIntepreter() {
    }

    @Override
    public String interprete(Node node) {
        return node.getValue();
    }

    @Override
    public String interprete(Add add) {
        return "(" + add.getA().inteprete(this) +"+"+ add.getB().inteprete(this) +")";
    }

    @Override
    public String interprete(Multiply multiply) {
        return multiply.getA().inteprete(this) +"*"+ multiply.getB().inteprete(this);
    }

    @Override
    public String interprete(Minus minus) {
        return "(-" + minus.getA().inteprete(this) + ")";
    }
}
