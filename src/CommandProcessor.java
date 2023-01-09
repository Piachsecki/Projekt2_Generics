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
        } else if (command.contains("PROCESS" )) {
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

            System.out.println(command);

            queueStack.welcome(new Person(name, surname, counter));
        }

        else {
            throw  new IllegalArgumentException("Sth went wrong");
        }
    }

    private void handleLeavePerson(String command) {
        System.out.println(command);
        String personID = command
                .replace("LEAVE PERSON(", "")
                .replace(")", "");

        Person splitID = createPerson(personID);

        queueStack.leave(splitID);



    }

    private Person createPerson(String personID) {

        String[] splitID = personID.split("_");

        String name = splitID[0];
        String surname = splitID[1];

        if (splitID.length == 2){
            return new Person(name, surname, 1);
        } else if (splitID.length == 3) {
            return new Person(name, surname, Integer.parseInt(splitID[2]));
        }
        throw new IllegalArgumentException("Sth went wrong" + personID);
    }

    private void handleProcess(String command) {
        queueStack.enter();
    }
}
