
import java.util.HashMap;
import java.util.Map;

// Interfaz para los objetos flyweight
interface Flyweight {
    void operation();
}

// Implementación concreta de los objetos flyweight
class ConcreteFlyweight implements Flyweight {
    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation() {
        System.out.println("Concrete Flyweight operation with intrinsic state: " + intrinsicState);
    }
}

// Fábrica de flyweights que gestiona los flyweights y los reutiliza si es posible
class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        if (!flyweights.containsKey(key)) {
            // Crea un nuevo flyweight si no existe uno
            flyweights.put(key, new ConcreteFlyweight(key));
        }
        return flyweights.get(key);
    }
}

// Clase cliente que utiliza los flyweights
public class Flyweight1 {
    public static void main(String[] args) {
        // Crea una fábrica de flyweights
        FlyweightFactory factory = new FlyweightFactory();
        // Obtiene flyweights compartidos
        Flyweight flyweight1 = factory.getFlyweight("key1");
        Flyweight flyweight2 = factory.getFlyweight("key2");
        Flyweight flyweight3 = factory.getFlyweight("key1"); // Reutiliza el flyweight existente
        // Realiza operaciones con los flyweights
        flyweight1.operation();
        flyweight2.operation();
        flyweight3.operation();
    }
}
