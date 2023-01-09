import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class Main {
        public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        QueueStack<Person> queueStack = new QueueStack<Person>(new ArrayDeque<>(), new ArrayDeque<>());
        CommandProcessor commandProcessor = new CommandProcessor(queueStack);

        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            commandProcessor.processCommand(command);
        }


    }
    }
