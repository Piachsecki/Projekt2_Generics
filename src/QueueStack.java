import java.util.*;

public class QueueStack<T> {
    private final Deque<T> queue;
    private final Deque<T> queueVip;
    private final Map<String, Integer> counterMap = new HashMap<>();

    public QueueStack(Deque<T> queue, Deque<T> vipqueue) {
        this.queue = queue;
        queueVip = vipqueue;
    }

    public Integer getCounter(String personKey) {
        Integer tempCounter = counterMap.getOrDefault(personKey, 0);
        tempCounter++;
        counterMap.put(personKey, tempCounter);
        return tempCounter;
    }

    public void welcomeVip(T incomingPerson) {
        queueVip.offer(incomingPerson);
        System.out.printf("%s came to the queue: %s%n", incomingPerson, queue.contains(incomingPerson));
        printQueue();
    }

    private void printQueue() {
        ArrayList<T> totalList = new ArrayList<>(queueVip);
        totalList.addAll(queue);

        System.out.println(totalList);
        System.out.println();
    }

    public void welcome(T item){
        boolean isAdded = queue.offer(item);
        System.out.printf("%s came to the queue: %s%n", item, isAdded);
        printQueue();

    }

    public void enter() {
        if(queueVip.isEmpty()){
            System.out.println("No items in the VIP QUEUE");
        }else {
            T itemEntered = queue.poll();
            System.out.printf("Processing queue: %s arrived at the store%n", itemEntered);
            printQueue();
            return;
        }

        if(queue.isEmpty()){
                throw new RuntimeException("QUEUE IS EMPTY");
            }


        T itemEntered = queue.poll();
        System.out.printf("Processing queue: %s arrived at the store%n", itemEntered);
       printQueue();
    }

    public void leave(T PersonId) {
        if(queueVip.contains(PersonId)){
            queueVip.remove(PersonId);
            System.out.printf("Leaving queue: %s%n", PersonId);
            printQueue();
        }else if(queue.contains(PersonId)){
            queue.remove(PersonId);
            System.out.printf("Leaving queue: %s%n", PersonId);
            printQueue();
        }
        else{
            System.out.println("not in the queue");
        }

    }
}
