// Interfaz para el iterador
interface Iterator {
    boolean hasNext();
    Object next();
}

// Interfaz para la colección iterable
interface Aggregate {
    Iterator createIterator();
}

// Implementación concreta del iterador
class ConcreteIterator implements Iterator {
    private String[] items;
    private int position = 0;

    public ConcreteIterator(String[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.length;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return items[position++];
        }
        return null;
    }
}

// Implementación concreta de la colección iterable
class ConcreteAggregate implements Aggregate {
    private String[] items;

    public ConcreteAggregate(String[] items) {
        this.items = items;
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(items);
    }
}

// Clase principal para probar el patrón Iterator
public class Iterator1 {
    public static void main(String[] args) {
        // Crea una colección de elementos
        String[] items = {"Item1", "Item2", "Item3"};
        Aggregate aggregate = new ConcreteAggregate(items);
        // Obtiene un iterador y recorre los elementos
        Iterator iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
