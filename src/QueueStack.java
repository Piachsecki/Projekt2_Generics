import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class QueueStack<T> {
    private final Deque<T> queue;
    private final Map<String, Integer> counterMap = new HashMap<>();

    public QueueStack(Deque<T> queue) {
        this.queue = queue;
    }

    public void welcome(T item){
        queue.offer(item);
        System.out.println(queue);
    }

    public Integer getCounter(String personKey) {
        Integer tempCounter = counterMap.getOrDefault(personKey, 0);
        tempCounter++;
        counterMap.put(personKey, tempCounter);
        return tempCounter;
    }
}
