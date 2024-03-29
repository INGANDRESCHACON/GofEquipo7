// Interfaz para el producto A
interface AbstractProductA {
    void operationA();
}

// Interfaz para el producto B
interface AbstractProductB {
    void operationB();
}

// Implementación concreta del producto A
class ConcreteProductA1 implements AbstractProductA {
    @Override
    public void operationA() {
        System.out.println("Concrete Product A1 operation");
    }
}

// Implementación concreta del producto B
class ConcreteProductB1 implements AbstractProductB {
    @Override
    public void operationB() {
        System.out.println("Concrete Product B1 operation");
    }
}

// Interfaz para la fábrica abstracta
interface AbstractFactory {
    AbstractProductA createProductA();
    AbstractProductB createProductB();
}

// Implementación concreta de la fábrica abstracta
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        // Crea y devuelve una instancia del producto A1
        return new ConcreteProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        // Crea y devuelve una instancia del producto B1
        return new ConcreteProductB1();
    }
}

// Clase principal para probar el patrón Abstract Factory


// Clase principal para probar el patrón Abstract Factory
public class AbstractFactory2 {
    public static void main(String[] args) {
        // Crear un objeto ConcreteFactory1
        AbstractFactory factory = new ConcreteFactory1();
        // Crear productos concretos A y B usando la fábrica
        AbstractProductA productA = factory.createProductA();
        AbstractProductB productB = factory.createProductB();
        // Invocar operaciones en los productos creados
        productA.operationA();
        productB.operationB();
    }
}
