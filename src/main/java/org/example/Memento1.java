package org.example;

// Clase que representa el estado a guardar
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Clase originadora que crea y restaura el estado
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void restoreStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}

// Clase cuidadora que administra los mementos
class Caretaker {
    private Memento memento;

    public void addMemento(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }
}

// Clase principal para probar el patrón Memento
public class Memento1 {
    public static void main(String[] args) {
        // Crea un originador y cuidador
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        // Establece el estado del originador y guarda el estado
        originator.setState("State1");
        caretaker.addMemento(originator.saveStateToMemento());
        // Cambia el estado del originador y guarda el estado nuevamente
        originator.setState("State2");
        caretaker.addMemento(originator.saveStateToMemento());
        // Restaura el estado anterior del originador
        originator.restoreStateFromMemento(caretaker.getMemento());
        System.out.println("Current state: " + originator.getState());
    }
}
