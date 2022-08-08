package sv.edu.sistemanotas;

public class Examen {
    private String fecha;

    public Examen(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "fecha='" + fecha + '\'' +
                '}';
    }
}
