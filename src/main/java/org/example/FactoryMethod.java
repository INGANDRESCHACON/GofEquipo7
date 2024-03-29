
interface Product {
    void operation();
}

// Implementación concreta de un producto
class ConcreteProduct implements Product {
    @Override
    public void operation() {
        System.out.println("Concrete Product operation");
    }
}

// Clase abstracta para el creador
abstract class Creator {
    // Método de fábrica abstracto que debe ser implementado por las subclases
    abstract Product factoryMethod();

    // Método común que utiliza el producto creado por el método de fábrica
    public void someOperation() {
        // Crea un producto utilizando el método de fábrica
        Product product = factoryMethod();
        // Utiliza el producto creado
        product.operation();
    }
}

// Implementación concreta del creador que crea un producto concreto
class ConcreteCreator extends Creator {
    @Override
    Product factoryMethod() {
        // Crea y devuelve una instancia del producto concreto
        return new ConcreteProduct();
    }
}

// Clase principal para probar el patrón Factory Method

public class FactoryMethod{
    public static void main(String[] args) {
        // Crear un objeto ConcreteCreator
        Creator creator = new ConcreteCreator();
        // Invocar el método someOperation que utiliza el Factory Method
        creator.someOperation();
    }
}
