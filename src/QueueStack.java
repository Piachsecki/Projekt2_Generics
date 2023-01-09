import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class QueueStack<T> {
    private final Deque<T> queue;
    private final Map<String, Integer> counterMap = new HashMap<>();

    public QueueStack(Deque<T> queue) {
        this.queue = queue;
    }

    public Integer getCounter(String personKey) {
        Integer tempCounter = counterMap.getOrDefault(personKey, 0);
        tempCounter++;
        counterMap.put(personKey, tempCounter);
        return tempCounter;
    }

    public void welcome(T item){
        boolean isAdded = queue.offer(item);
        System.out.printf("%s came to the queue: %s%n", item, isAdded);
        System.out.println(queue);
        System.out.println();

    }

    public void enter() {
        if(queue.isEmpty()){
            throw new RuntimeException("QUEUE IS EMPTY");
        }

        T itemEntered = queue.poll();
        System.out.printf("Processing queue: %s arrived at the store%n", itemEntered);
        System.out.println(queue);
        System.out.println();
    }

    public void leave(T PersonId) {
        if(queue.contains(PersonId)){
            queue.remove(PersonId);
            System.out.printf("Leaving queue: %s%n", PersonId);
            System.out.println(queue);
            System.out.println();
        }else{
            System.out.println("not in the queue");
        }
    }
}
