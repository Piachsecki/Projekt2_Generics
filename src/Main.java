import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        QueueStack<Person> queueStack = new QueueStack<Person>(new ArrayDeque<>());
        CommandProcessor commandProcessor = new CommandProcessor(queueStack);
        List<String> commandList = List.of(
                "ADD PERSON(Tomasz_Romański)",
                "ADD PERSON(Tomasz_Romański)",
                "ADD PERSON(Tomasz_Romański)",
                "ADD PERSON(Rafał_Adamczuk)",
                "ADD PERSON(Tomasz_Romański)",
                "ADD PERSON(Mariusz_Wilczek)",
                "ADD PERSON(Zbigniew_Ratownik)",
                "PROCESS",
                "LEAVE PERSON(Mariusz_Wilczek)",
                "LEAVE PERSON(Tomasz_Romański_3)"
//                "PROCESS",
//                "PROCESS",
//                "PROCESS"
        );

        for (String command : commandList) {
            commandProcessor.processCommand(command);
        }

    }
}