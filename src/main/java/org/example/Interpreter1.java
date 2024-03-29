package org.example;

// Contexto utilizado por las expresiones para evaluar y almacenar resultados intermedios
class context {
    public boolean lookup(String name) {
        // Simula la búsqueda de una variable en el contexto
        return name.equals("true");
    }
}

// Interfaz para las expresiones
interface Expression {
    boolean interpret(context context);
}

// Implementación concreta de una expresión terminal
class TerminalExpression implements Expression {
    private String variable;

    public TerminalExpression(String variable) {
        this.variable = variable;
    }

    @Override
    public boolean interpret(context context) {
        // Evalúa la expresión terminal utilizando el contexto
        return context.lookup(variable);
    }
}

// Implementación concreta de una expresión no terminal
class NonTerminalExpression implements Expression {
    private Expression expression1;
    private Expression expression2;

    public NonTerminalExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(context context) {
        // Evalúa la expresión no terminal utilizando el contexto y las expresiones internas
        return expression1.interpret(context) && expression2.interpret(context);
    }
}

// Clase principal para probar el patrón Interpreter
public class Interpreter1 {
    public static void main(String[] args) {
        // Crea instancias de las expresiones terminales y no terminales
        Expression expression1 = new TerminalExpression("true");
        Expression expression2 = new TerminalExpression("false");
        Expression expression3 = new NonTerminalExpression(expression1, expression2);
        // Crea un contexto y evalúa la expresión no terminal
        context context = new context();
        boolean result = expression3.interpret(context);
        System.out.println("Result of interpretation: " + result);
    }
}
