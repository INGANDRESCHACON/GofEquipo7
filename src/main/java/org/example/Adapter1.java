package org.example;

// Interfaz objetivo que el cliente espera
interface Target {
    void request();
}

// Implementación concreta de la interfaz objetivo
class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("Concrete Target request");
    }
}

// Adaptee (clase existente que debe ser adaptada)
class Adaptee {
    public void specificRequest() {
        System.out.println("Adaptee specific request");
    }
}

// Adaptador que adapta Adaptee a Target
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        // Utiliza Adaptee para cumplir con la solicitud de Target
        adaptee.specificRequest();
    }
}

// Clase principal para probar el patrón Adapter
public class Adapter1 {
    public static void main(String[] args) {
        // Crea un objeto de la clase existente (Adaptee)
        Adaptee adaptee = new Adaptee();
        // Crea un adaptador que utiliza Adaptee
        Target adapter = new Adapter(adaptee);
        // Utiliza el adaptador para cumplir con la solicitud de Target
        adapter.request();
    }
}
