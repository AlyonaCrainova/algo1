package task_4;

import java.util.Stack;

public class PostfixStatement {
    private Integer previousResult;

    public Integer calculate(String input) throws NumberFormatException {
        String reversedInput = new StringBuilder(input).reverse().toString();
        Stack<String> stack_1 = new Stack<>();
        Stack<String> stack_2 = new Stack<>();
        for (String operand : reversedInput.split(" ")) {
            stack_1.push(operand);
        }
        while (!stack_1.isEmpty()) {
            String operand = stack_1.pop();
            switch (operand) {
                case "+" -> {
                    int result = Integer.parseInt(stack_2.pop()) + Integer.parseInt(stack_2.pop());
                    stack_2.push(String.valueOf(result));
                }
                case "*" -> {
                    int result = Integer.parseInt(stack_2.pop()) * Integer.parseInt(stack_2.pop());
                    stack_2.push(String.valueOf(result));
                }
                case "=" -> {
                    return Integer.parseInt(stack_2.pop());
                }
                default -> stack_2.push(operand);
            }
        }
        previousResult = Integer.parseInt(stack_2.pop());
        return null;
    }

    public Integer getPreviousResult(){
        return previousResult;
    }
}
