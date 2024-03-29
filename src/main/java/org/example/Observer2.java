import java.util.ArrayList;
import java.util.List;

// Interfaz para los observadores
interface Observer {
    void update(String message);
}

// Implementación concreta de un observador
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

// Interfaz para el sujeto observable
interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(String message);
}

// Implementación concreta del sujeto observable
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// Clase principal para probar el patrón Observer
public class Observer2 {
    public static void main(String[] args) {
        // Crea un sujeto observable y algunos observadores
        Subject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver("Observer1");
        Observer observer2 = new ConcreteObserver("Observer2");
        // Adjunta los observadores al sujeto observable
        subject.attach(observer1);
        subject.attach(observer2);
        // Notifica a los observadores
        subject.notifyObservers("Hello");
    }
}
