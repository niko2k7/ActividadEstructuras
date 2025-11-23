package Models;

public class Paciente {
    public String nombre;
    public int edad;

    public Paciente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre + " (edad: " + edad + ")";
    }
}
