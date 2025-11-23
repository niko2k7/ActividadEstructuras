package Models;

public class Nodo {
    public Paciente paciente;
    public int prioridad;

    public Nodo(Paciente paciente, int prioridad) {
        this.paciente = paciente;
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return paciente + " - prioridad: " + prioridad;
    }
}
