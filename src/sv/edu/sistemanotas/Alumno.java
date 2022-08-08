package sv.edu.sistemanotas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alumno {
    private String nombre;
    private String apellido;
    private String DUI;
    private List<Examen> examenes = new ArrayList<>();

    public Alumno(String nombre,String apellido,String DUI){
        this.nombre=nombre;
        this.apellido=apellido;
        this.DUI=DUI;
    }

    public Alumno() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public List<Examen> getExamenes() {
        return examenes;
    }

    public void setExamenes(Examen examen) {
        this.examenes.add(examen);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", DUI='" + DUI + '\'' +
                ", examenes=" + examenes +
                '}';
    }
}
