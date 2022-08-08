package sv.edu.sistemanotas;

public class ExamenOral extends Examen{
    private String nivel_satisfaccion;

    public ExamenOral(String fecha, String nivel_satisfaccion) {
        super(fecha);
        this.nivel_satisfaccion = nivel_satisfaccion;
    }

    public String getNivel_satisfaccion() {
        return nivel_satisfaccion;
    }

    public void setNivel_satisfaccion(String nivel_satisfaccion) {
        this.nivel_satisfaccion = nivel_satisfaccion;
    }

    @Override
    public String toString() {
        return "ExamenOral{" +
                "nivel_satisfaccion='" + nivel_satisfaccion + '\'' +
                "} " + super.toString();
    }
}
