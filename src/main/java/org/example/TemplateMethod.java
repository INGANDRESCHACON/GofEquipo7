package org.example;
// Clase abstracta que define el esqueleto del algoritmo
abstract class AbstractClass {
    public void templateMethod() {
        step1();
        step2();
        step3();
    }

    abstract void step1();
    abstract void step2();
    abstract void step3();
}

// Implementación concreta de la clase abstracta
class ConcreteClass extends AbstractClass {
    @Override
    void step1() {
        System.out.println("Step 1");
    }

    @Override
    void step2() {
        System.out.println("Step 2");
    }

    @Override
    void step3() {
        System.out.println("Step 3");
    }
}

// Clase principal para probar el patrón Template Method
public class TemplateMethod {
    public static void main(String[] args) {
        // Crea una instancia de la clase concreta y llama al método de plantilla
        AbstractClass template = new ConcreteClass();
        template.templateMethod();
    }
}

