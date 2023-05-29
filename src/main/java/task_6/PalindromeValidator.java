package task_6;

public class PalindromeValidator {
    public boolean isPalindrome(String input) {
        String clearedInput = input.replaceAll("[^a-zA-Zа-яА-Я]",  "").toLowerCase();
        if (clearedInput.isEmpty()) {
            return false;
        }
        Deque<String> direct_order = new Deque<>();
        Deque<String> reverse_order = new Deque<>();
        for (String operand: clearedInput.split(" ")) {
            direct_order.addTail(operand);
            reverse_order.addTail(operand);
        }
        while (direct_order.size() > 0 && reverse_order.size() > 0){
            if(!direct_order.removeFront().equals(reverse_order.removeTail())){
                return false;
            }
        }
        return true;
    }
}
