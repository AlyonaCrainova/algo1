package task_5;

import java.util.Queue;

public class QueueRotator {
    public void rotate(Queue<Integer> queue, int number){
        for(int i = 0; i < number; i++){
            queue.add(queue.poll());
        }
    }
}
