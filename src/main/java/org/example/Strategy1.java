package org.example;

// Interfaz para las estrategias
interface Strategy {
    void execute();
}

// Implementación concreta de una estrategia
class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy A");
    }
}

// Implementación alternativa de una estrategia
class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy B");
    }
}

// Contexto que utiliza una estrategia
class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.execute();
    }
}

// Clase principal para probar el patrón Strategy
public class Strategy1 {
    public static void main(String[] args) {
        // Crea un contexto
        Context context = new Context();
        // Configura y utiliza la estrategia A
        context.setStrategy(new ConcreteStrategyA());
        context.executeStrategy();
        // Configura y utiliza la estrategia B
        context.setStrategy(new ConcreteStrategyB());
        context.executeStrategy();
    }
}

