import java.util.ArrayList;
import java.util.List;

// Componente base
interface Component {
    void operation();
}

// Componente hoja
class Leaf implements Component {
    @Override
    public void operation() {
        System.out.println("Leaf operation");
    }
}

// Componente compuesto que contiene otros componentes
class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        for (Component component : children) {
            component.operation();
        }
    }
}

// Clase principal para probar el patrón Composite
public class Composite1 {
    public static void main(String[] args) {
        // Crea componentes hoja
        Component leaf1 = new Leaf();
        Component leaf2 = new Leaf();
        // Crea un componente compuesto
        Composite composite = new Composite();
        // Agrega las hojas al componente compuesto
        composite.add(leaf1);
        composite.add(leaf2);
        // Invoca la operación en el componente compuesto
        composite.operation();
    }
}
