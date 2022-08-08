package sv.edu.sistemanotas;

public interface CalcularPromedio {
    Integer verAprobados();
    void verReprobados();

    boolean existAlumno(String dui);

    void agregarExamen(Examen examen,String dui);

    void agregarAlumno(String nombre,String apellido,String DUI);

    void verListaAlumnos();
}
