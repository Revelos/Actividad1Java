package sv.edu.sistemanotas;

public class ExamenEscrito extends Examen{
    private Double duraccion;
    private Double nota;

    public ExamenEscrito(String fecha, Double duraccion, Double nota) {
        super(fecha);
        this.duraccion = duraccion;
        this.nota = nota;
    }

    public Double getDuraccion() {
        return duraccion;
    }

    public void setDuraccion(Double duraccion) {
        this.duraccion = duraccion;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "ExamenEscrito{" +
                "duraccion=" + duraccion +
                ", nota=" + nota +
                "} " + super.toString();
    }
}
