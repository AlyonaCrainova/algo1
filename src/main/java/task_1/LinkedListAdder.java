package task_1;

import java.util.ArrayList;

public class LinkedListAdder {
    public ArrayList<Node> sum(LinkedList addendum_1, LinkedList addendum_2) throws NullPointerException{
        ArrayList<Node> sum = new ArrayList<>();
        int count = addendum_1.count();
        if ( count == addendum_2.count()){
            Node current_1 = addendum_1.head;
            Node current_2 = addendum_2.head;
            for (int i = 0; i < count; i ++){
                sum.add( new Node(current_1.value + current_2.value));
                current_1 = current_1.next;
                current_2 = current_2.next;
            }
        }
        return sum;
    }
}
