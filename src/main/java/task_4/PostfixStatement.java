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
            if (operand.equals("=")) {
                return stack_2.pop();
            }
            if (operand.matches("[0-9]+")) {
                stack_2.push(Double.parseDouble(operand));
                continue;
            }
            Double right = stack_2.pop();
            Double left = stack_2.pop();
            switch (operand) {
                case "+" -> stack_2.push(left + right);
                case "-" -> stack_2.push(left - right);
                case "*" -> stack_2.push(left * right);
                case "/" -> stack_2.push(left / right);
            }
        }
        previousResult = stack_2.pop();
        return null;
    }

    public Double getPreviousResult() {
        return previousResult;
    }
}
