package interpreter;

import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Expression expr = new Add(new Multiply(new Minus(a), b), c);

        Map<String, Boolean> variables = Map.ofEntries(
                Map.entry("a", true),
                Map.entry("b", false),
                Map.entry("c", true)
        );

        Interpreter<Boolean> interpreter = new BooleanInterpreter(variables);

        System.out.println(expr.inteprete(interpreter));

        Map<String, Integer> variablesInteger = Map.ofEntries(
                Map.entry("a", 3),
                Map.entry("b", 4),
                Map.entry("c", 5)
        );

        System.out.println(expr.inteprete(new IntegerIntepreter(variablesInteger)));

        System.out.println(expr.inteprete(new ReadableIntepreter()));

        String input = "4 2 3 + * a - +";

        Expression expression = PolishParser.parse(input);
        System.out.println(expression.inteprete(new ReadableIntepreter()));

    }
}
