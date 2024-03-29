package org.example;

// Producto que se va a construir
class Product {
    private String partA;
    private String partB;
    private String partC;

    // Métodos para establecer partes del producto
    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    // Método para mostrar el producto construido
    public void show() {
        System.out.println("Product parts: " + partA + ", " + partB + ", " + partC);
    }
}

// Interfaz para el constructor
interface Builder {
    void buildPartA();
    void buildPartB();
    void buildPartC();
    Product getProduct();
}

// Implementación concreta del constructor
class ConcreteBuilder implements Builder {
    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.setPartA("PartA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("PartB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("PartC");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}

// Director que utiliza el constructor para construir un producto
class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}

// Clase principal para probar el patrón Builder
public class Builder1{
    public static void main(String[] args) {
        // Crear un objeto ConcreteBuilder
        Builder builder = new ConcreteBuilder();
        // Crear un objeto Director con el constructor
        Director director = new Director(builder);
        // Construir el producto utilizando el director
        director.construct();
        // Obtener el producto construido
        Product product = builder.getProduct();
        // Mostrar el producto
        product.show();
    }
}


