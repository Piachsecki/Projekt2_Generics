public class CommandProcessor {
    private final QueueStack<Person> queueStack;

    public CommandProcessor(QueueStack<Person> queueStack) {
        this.queueStack = queueStack;
    }

    public void processCommand(String command) {
        if(command.contains("ADD PERSON")){
            handleAddPerson(command);
        } else if (command.contains("LEAVE PERSON" )){
            handleLeavePerson(command);
        } else if (command.contains("PROCCES" )) {
            handleProcess(command);
        }else {
            throw new RuntimeException("O co ci chodzi?" + command );
        }

    }

    private void handleAddPerson(String command) {
        String personKey = command
                .replace("ADD PERSON(", "" )
                .replace(")", "" );

        String[] split = personKey
                .split("_");

        if (split.length == 2){
            String name = split[0];
            String surname = split[1];
            Integer counter = queueStack.getCounter(personKey);

            queueStack.welcome(new Person(name, surname, counter));
        }
    }

    private void handleLeavePerson(String command) {
    }

    private void handleProcess(String command) {

    }
}
