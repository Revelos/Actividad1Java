package sv.edu.sistemanotas;

import java.util.ArrayList;
import java.util.List;

public class CalcularPromedioImpl implements CalcularPromedio {

    public static List<Alumno> alumnos = new ArrayList<>();

    @Override
    public Integer verAprobados() {
        Integer aprobados = 0;// numero total de alumnos aprobados
        Integer cantExamenes = 0;//numero de examenes realizados por el alumno
        Integer examsAprobados = 0;//numero de examenes aprobados por el alumno
        System.out.println("\t\tDETALLE DE ALUMNOS APROBADOS:\n");
        for (Alumno alumno1 : alumnos) {
            examsAprobados = 0;
            cantExamenes = alumno1.getExamenes().size();

            for (Examen examen :
                    alumno1.getExamenes()) {
                if (examen instanceof ExamenEscrito) {
                    ExamenEscrito exes = (ExamenEscrito) examen;
                    if (exes.getDuraccion() < 90 && exes.getNota() >= 6) {
                        ++examsAprobados;
                    }
                } else if (examen instanceof ExamenOral) {
                    ExamenOral exor = (ExamenOral) examen;
                    if (exor.getNivel_satisfaccion() != Satisfaccion.INSUFICIENTE.toString()) {
                        ++examsAprobados;
                    }
                }
            }
            //si la cantidad de examenes es la misma de los examenes aprobados
            //entonces lo agregamos a la lista de alumnos aprobados e imprimos el detalle
            if (examsAprobados == cantExamenes && cantExamenes > 0) {
                ++aprobados;
                System.out.println("\t* "+alumno1+"\n");
            }
        }

        return aprobados;
    }

    @Override
    public void verReprobados() {
        Integer cantExamenes = 0;
        Integer examsAprobados = 0;
        System.out.println("\t\tLISTA DE ALUMNOS DESAPROBADOS:\n");
        for (Alumno alumno1 : alumnos) {
            examsAprobados = 0;
            cantExamenes = alumno1.getExamenes().size();

            for (Examen examen :
                    alumno1.getExamenes()) {
                if (examen instanceof ExamenEscrito) {
                    ExamenEscrito exes = (ExamenEscrito) examen;
                    if (exes.getDuraccion() < 90 && exes.getNota() >= 6) {
                        ++examsAprobados;
                    }
                } else if (examen instanceof ExamenOral) {
                    ExamenOral exor = (ExamenOral) examen;
                    if (exor.getNivel_satisfaccion() != Satisfaccion.INSUFICIENTE.toString()) {
                        ++examsAprobados;
                    }
                }
            }

            if (examsAprobados != cantExamenes && cantExamenes > 0) {
                System.out.println(alumno1);
            }
        }
    }

    @Override
    public boolean existAlumno( String dui) {
        for (Alumno alumno :
                alumnos) {
            if (alumno.getDUI().equals(dui)) {
                return true;
            }
        }
        return false;

    }

    @Override
    public void agregarExamen( Examen examen, String dui) {
        for (Alumno alumno :
                alumnos) {
            if(alumno.getDUI().equals(dui)){
                alumno.setExamenes(examen);
            }
        }
    }

    @Override
    public void agregarAlumno(String nombre,String apellido,String dui) {
        Alumno alumno = new Alumno(nombre,apellido,dui);
        alumnos.add(alumno);
        System.out.println("\tAlumno agregado con exito!");
    }

    @Override
    public void verListaAlumnos() {
        if(alumnos.isEmpty()){
            System.out.println("No hay alumnos registrados");
        }else{
            System.out.println("\t\tLISTA DE ALUMNOS REGISTRADOS\n");
            alumnos.forEach((alumno -> {
                System.out.printf("\t* "+alumno.toString()+"\n");
            }));
        }

    }
}
