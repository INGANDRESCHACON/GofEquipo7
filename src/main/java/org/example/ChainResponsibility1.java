package org.example;

// Interfaz para manejar las solicitudes
interface Handler {
    void setNextHandler(Handler handler);
    void handleRequest(int request);
}

// Implementación base para los manejadores
abstract class BaseHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler handler) {
        nextHandler = handler;
    }

    protected void passToNext(int request) {
        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// Implementación concreta del manejador
class ConcreteHandler extends BaseHandler {
    private int threshold;

    public ConcreteHandler(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public void handleRequest(int request) {
        if (request <= threshold) {
            System.out.println("Request handled by ConcreteHandler with threshold " + threshold);
        } else {
            passToNext(request);
        }
    }
}

// Clase principal para probar el patrón Chain of Responsibility
public class ChainResponsibility1 {
    public static void main(String[] args) {
        // Crea instancias de los manejadores
        Handler handler1 = new ConcreteHandler(10);
        Handler handler2 = new ConcreteHandler(20);
        Handler handler3 = new ConcreteHandler(30);
        // Establece la cadena de responsabilidad
        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);
        // Maneja las solicitudes
        handler1.handleRequest(15);
        handler1.handleRequest(25);
        handler1.handleRequest(35);
    }
}
