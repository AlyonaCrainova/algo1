package task_4;

import java.util.*;
import java.util.Stack;

public class PostfixStatement {
    private Double previousResult;

    public Double calculate(String input) throws InvalidInputException, NumberFormatException {
        if (!input.matches("[0-9]+(\\s[0-9]+\\s[\\-+/*=](\\s=)?)+")) {
            throw new InvalidInputException("Form of " + input + "is prohibited");
        }
        Stack<String> stack_1 = new Stack<>();
        Stack<Double> stack_2 = new Stack<>();
        List<String> reversedInput = Arrays.asList(input.split(" "));
        Collections.reverse(reversedInput);
        for (String operand : reversedInput) {
            stack_1.push(operand);
        }
        while (!stack_1.isEmpty()) {
            String operand = stack_1.pop();
            switch (operand) {
                case "+" -> stack_2.push(stack_2.pop() + stack_2.pop());
                case "-" -> {
                    Double subtrahend = stack_2.pop();
                    Double minuend = stack_2.pop();
                    stack_2.push(minuend - subtrahend);
                }
                case "*" -> stack_2.push(stack_2.pop() * stack_2.pop());
                case "/" -> {
                    Double divisor = stack_2.pop();
                    Double dividend = stack_2.pop();
                    stack_2.push(dividend / divisor);
                }
                case "=" -> {
                    return stack_2.pop();
                }
                default -> stack_2.push(Double.parseDouble(operand));
            }
        }
        previousResult = stack_2.pop();
        return null;
    }

    public Double getPreviousResult() {
        return previousResult;
    }
}
