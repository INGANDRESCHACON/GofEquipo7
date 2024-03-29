package org.example;

// Interfaz para los comandos
interface Command {
    void execute();
}

// Implementación concreta de un comando
class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}

// Receptor que realiza la acción real
class Receiver {
    public void action() {
        System.out.println("Receiver action");
    }
}

// Invocador que ejecuta los comandos
class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

// Clase principal para probar el patrón Command
public class Command1 {
    public static void main(String[] args) {
        // Crea instancias de los objetos Command, Receiver e Invoker
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        // Configura y ejecuta el comando a través del invocador
        invoker.setCommand(command);
        invoker.executeCommand();
    }
}
