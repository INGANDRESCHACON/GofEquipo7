package org.example;

// Componente base
interface Component {
    void operation();
}

// Implementación concreta del componente base
class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("Concrete Component operation");
    }
}

// Decorador base
abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

// Decorador concreto que añade funcionalidad adicional
class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        // Llama a la operación del componente base
        super.operation();
        // Agrega funcionalidad adicional
        System.out.println("Concrete Decorator operation");
    }
}

// Clase principal para probar el patrón Decorator
public class Decorator1 {
    public static void main(String[] args) {
        // Crea un componente concreto
        Component component = new ConcreteComponent();
        // Crea un decorador concreto y le pasa el componente
        Component decorator = new ConcreteDecorator(component);
        // Invoca la operación en el decorador
        decorator.operation();
    }
}
