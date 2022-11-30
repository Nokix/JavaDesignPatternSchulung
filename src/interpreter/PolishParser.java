package interpreter;

import java.util.Stack;

public class PolishParser {
    public static Expression parse(String input) {
        Stack<Expression> stack = new Stack<>();
        String[] parts = input.split(" ");

        for (String part : parts) {
            Expression expression = switch (part) {
                case "+" -> new Add(stack.pop(), stack.pop());
                case "-" -> new Minus(stack.pop());
                case "*" -> new Multiply(stack.pop(), stack.pop());
                default -> new Node(part);
            };
            stack.add(expression);
        }
        return stack.pop();
    }
}
