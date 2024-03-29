
// Interfaz para los visitantes
interface Visitor {
    void visit(ElementA element);
    void visit(ElementB element);
}

// Interfaz para los elementos visitables
interface Element {
    void accept(Visitor visitor);
}

// Implementación concreta de un elemento visitable
class ElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Implementación alternativa de un elemento visitable
class ElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Implementación concreta de un visitante
class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ElementA element) {
        System.out.println("Visitor visits Element A");
    }

    @Override
    public void visit(ElementB element) {
        System.out.println("Visitor visits Element B");
    }
}

// Clase principal para probar el patrón Visitor
public class Visitor2 {
    public static void main(String[] args) {
        // Crea instancias de elementos y un visitante
        Element elementA = new ElementA();
        Element elementB = new ElementB();
        Visitor visitor = new ConcreteVisitor();
        // Permite que el visitante visite los elementos
        elementA.accept(visitor);
        elementB.accept(visitor);
    }
}
