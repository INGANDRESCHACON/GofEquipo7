package org.example;

// Implementación del patrón Singleton
class Singleton {
    // Instancia única del Singleton
    private static Singleton instance;

    // Constructor privado para evitar la creación de instancias externas
    private Singleton() {}

    // Método estático para obtener la instancia única del Singleton
    public static Singleton getInstance() {
        // Crea la instancia si aún no existe
        if (instance == null) {
            instance = new Singleton();
        }
        // Devuelve la instancia única
        return instance;
    }
}

// Clase principal para probar el patrón Singleton
public class Singleton1 {
    public static void main(String[] args) {
        // Obtiene la instancia única del Singleton
        Singleton singleton1 = Singleton.getInstance();
        // Obtiene otra instancia del Singleton
        Singleton singleton2 = Singleton.getInstance();
        // Verifica si las dos instancias son iguales
        System.out.println("Are singleton1 and singleton2 the same instance? " + (singleton1 == singleton2));
    }
}
