package task_6;

public class PalindromeValidator {
    public boolean isPalindrome(String input) {
        String clearedInput = input.replaceAll("[^a-zA-Zа-яА-Я]",  "").toLowerCase();
        if (clearedInput.isEmpty()) {
            return false;
        }
        Deque<String> deque = new Deque<>();
        for (String operand: clearedInput.split(" ")) {
            deque.addTail(operand);
        }
        while (deque.size() > 1){
            if(!deque.removeFront().equals(deque.removeTail())){
                return false;
            }
        }
        return true;
    }
}
