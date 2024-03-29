
// Interfaz para los estados
interface State {
    void handle();
}

// Implementación concreta de un estado
class ConcreteState implements State {
    @Override
    public void handle() {
        System.out.println("Concrete State handles the request");
    }
}

// Contexto que utiliza un estado
class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handle();
    }
}

// Clase principal para probar el patrón State
public class State1 {
    public static void main(String[] args) {
        // Crea un contexto y establece un estado inicial
        Context contextt = new Context();
        contextt.setState(new ConcreteState());
        // Realiza una solicitud que será manejada por el estado actual
        contextt.request();
    }
}
