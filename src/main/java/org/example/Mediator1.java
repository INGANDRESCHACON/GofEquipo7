package org.example;

// Interfaz para el mediador
interface Mediator {
    void sendMessage(String message, Colleague colleague);
}

// Interfaz para los colegas
interface Colleague {
    void receiveMessage(String message);
    void sendMessage(String message);
}

// Implementación concreta del mediador
class ConcreteMediator implements Mediator {
    private Colleague colleague1;
    private Colleague colleague2;

    public void setColleague1(Colleague colleague) {
        this.colleague1 = colleague;
    }

    public void setColleague2(Colleague colleague) {
        this.colleague2 = colleague;
    }

    @Override
    public void sendMessage(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague2.receiveMessage(message);
        } else {
            colleague1.receiveMessage(message);
        }
    }
}

// Implementación concreta de un colega
class ConcreteColleague implements Colleague {
    private Mediator mediator;

    public ConcreteColleague(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }
}

// Clase principal para probar el patrón Mediator
public class Mediator1{
    public static void main(String[] args) {
        // Crea un mediador
        Mediator mediator = new ConcreteMediator();
        // Crea colegas y los vincula al mediador
        Colleague colleague1 = new ConcreteColleague(mediator);
        Colleague colleague2 = new ConcreteColleague(mediator);
        ((ConcreteMediator) mediator).setColleague1(colleague1);
        ((ConcreteMediator) mediator).setColleague2(colleague2);
        // Envía mensajes entre colegas a través del mediador
        colleague1.sendMessage("Message from colleague 1");
        colleague2.sendMessage("Message from colleague 2");
    }
}
