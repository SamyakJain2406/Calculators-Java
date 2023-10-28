import java.util.Queue;
import java.util.LinkedList;

public class queue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Enqueue (add) elements to the queue
        queue.offer(1);
        queue.offer(5201314);
        queue.offer(2);
        queue.offer(3);

        System.out.println("This is a Queue: " + queue);

        
        // Dequeue (remove and return) elements from the queue
        int dequeuedElement = queue.poll();
        System.out.println("Dequeued element: " + dequeuedElement);

        System.out.println("Queue after dequeue: " + queue);
    }
}
