package org.example;

// Clase compleja que se oculta detrás de la fachada
class Subsystem {
    public void operation1() {
        System.out.println("Subsystem operation 1");
    }

    public void operation2() {
        System.out.println("Subsystem operation 2");
    }

    public void operation3() {
        System.out.println("Subsystem operation 3");
    }
}

// Fachada que proporciona una interfaz simplificada a la clase compleja
class Facade {
    private Subsystem subsystem = new Subsystem();

    public void operation() {
        // Utiliza la funcionalidad del subsistema de manera simplificada
        subsystem.operation1();
        subsystem.operation2();
        subsystem.operation3();
    }
}

// Clase principal para probar el patrón Facade
public class Facade1{
    public static void main(String[] args) {
        // Crea una instancia de la fachada
        Facade facade = new Facade();
        // Utiliza la fachada para realizar operaciones complejas de manera simplificada
        facade.operation();
    }
}
