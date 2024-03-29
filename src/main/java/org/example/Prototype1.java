// Interfaz para el prototipo
interface Prototype {
    Prototype clone();
}

// Implementación concreta del prototipo
class ConcretePrototype implements Prototype {
    @Override
    public Prototype clone() {
        // Crea y devuelve una copia del prototipo
        return new ConcretePrototype();
    }
}

// Clase principal para probar el patrón Prototype
public class Prototype1 {
    public static void main(String[] args) {
        // Crea un objeto prototipo
        Prototype prototype = new ConcretePrototype();
        // Clona el prototipo para obtener una copia
        Prototype clone = prototype.clone();
        // Verifica si el clon es una instancia diferente del prototipo original
        System.out.println("Is clone a different instance? " + (clone != prototype));
    }
}
