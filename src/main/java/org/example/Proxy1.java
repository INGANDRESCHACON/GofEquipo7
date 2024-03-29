package org.example;

// Interfaz para el objeto real y el proxy
interface Subject {
    void request();
}

// Implementación concreta del objeto real
class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("Real Subject request");
    }
}

// Proxy que controla el acceso al objeto real
class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void request() {
        // Crea el objeto real solo cuando es necesario
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        // Delega la solicitud al objeto real
        realSubject.request();
    }
}

// Clase principal para probar el patrón Proxy
public class Proxy1 {
    public static void main(String[] args) {
        // Crea un proxy
        Proxy proxy = new Proxy();
        // Invoca el método a través del proxy
        proxy.request();
    }
}
