package org.example;

// Implementación de la implementación independiente
interface Implementor {
    void operationImpl();
}

// Implementación concreta de Implementor
class ConcreteImplementor implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("Concrete Implementor operation");
    }
}

// Abstracción que define la interfaz de alto nivel
abstract class Abstraction {
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    abstract void operation();
}

// Refinamiento de la abstracción
class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    void operation() {
        // Delega la operación a la implementación
        implementor.operationImpl();
    }
}

// Clase principal para probar el patrón Bridge
public class Bridge1{
    public static void main(String[] args) {
        // Crea una instancia de la implementación concreta
        Implementor implementor = new ConcreteImplementor();
        // Crea una instancia de la abstracción refinada
        Abstraction abstraction = new RefinedAbstraction(implementor);
        // Invoca la operación a través de la abstracción
        abstraction.operation();
    }
}
