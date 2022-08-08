package sv.edu.main;

import sv.edu.sistemanotas.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaNotas {

    private static Integer opcion = -1;
    private static final Scanner scanner = new Scanner(System.in);
    private static CalcularPromedio cp = new CalcularPromedioImpl();

    public static void main(String[] args) {
        do {
            try {
                System.out.println("BIENVENIDO AL REGISTRO DE NOTAS");
                System.out.println("Seleccione una opcion");
                System.out.println("1. Agregar alumno");
                System.out.println("2. Anexar examen");
                System.out.println("3. Alumnos aprobados");
                System.out.println("4. Alumnos reprobados");
                System.out.println("5. Lista completa de alumnos");
                System.out.println("0. Salir");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nombre del alumno");
                        String nombre = scanner.next();
                        System.out.println("Ingrese el apellido del alumno");
                        String apellido = scanner.next();
                        System.out.println("Ingrese el # DUI del alumno");
                        String dui = scanner.next();
                        boolean existe= cp.existAlumno(dui);
                        if(existe){
                            System.out.println("Ya existe alumno con ese # DUI");
                            break;
                        }
                        cp.agregarAlumno(nombre,apellido,dui);
                        break;
                    case 2:
                        Integer op = -1;
                        System.out.println("Ingrese el # DUI del alumno");
                        String clave = scanner.next();
                        boolean exist= cp.existAlumno(clave);
                        if(!exist){
                            System.out.println("No existe alumno con ese DUI");
                            break;
                        }
                        do{
                            System.out.println("Seleccione una opcion");
                            System.out.println("1.Examen oral");
                            System.out.println("2.Examen escrito");
                            System.out.println("0.Salir");
                            op = scanner.nextInt();
                            switch (op){
                                case 1:
                                    System.out.println("Ingrese la fecha que se realizo el examen");
                                    String fecha1 = scanner.next();
                                    System.out.println("Seleccione el nivel de satisfaccion: 1. "+Satisfaccion.EXCELENTE+"\t2. "+Satisfaccion.INSUFICIENTE+"\t3. "+Satisfaccion.SUFICIENTE);
                                    Integer opcion = scanner.nextInt();
                                    String satisfaccion = opcion==1?Satisfaccion.EXCELENTE.name() : opcion==2?Satisfaccion.INSUFICIENTE.name():Satisfaccion.SUFICIENTE.name();
                                    Examen exOral = new ExamenOral(fecha1,satisfaccion);
                                    cp.agregarExamen(exOral,clave);
                                    break;
                                case 2:
                                    System.out.println("Ingrese la fecha que se realizo el examen");
                                    String fecha = scanner.next();
                                    System.out.println("Ingrese el tiempo en minutos");
                                    String tiempo = scanner.next();
                                    System.out.println("Ingrese la nota que obtuvo");
                                    String nota = scanner.next();
                                    Examen exEscrito = new ExamenEscrito(fecha,Double.parseDouble(tiempo),Double.parseDouble(nota));
                                    cp.agregarExamen(exEscrito,clave);
                                    break;
                            }

                        }while (op!=0);

                        break;
                    case 3:
                        Integer numAprobados = cp.verAprobados();
                        System.out.println("Numero de aprobados " + numAprobados + " de " + CalcularPromedioImpl.alumnos.size() + " alumnos");
                        break;
                    case 4:
                        cp.verReprobados();
                        break;
                    case 5:
                        cp.verListaAlumnos();
                        break;
                    case 0:
                        System.out.println("Hasta pronto");
                    default:
                        System.out.println("\n");
                }
            }catch (InputMismatchException ex){
                System.out.println("Error de entrada de datos!! ");
            }
            scanner.nextLine(); //Limpiamos buffer del System.in
            System.out.println("\n\t\tPRESIONE ENTER PARA CONTINUAR..."); //Mensaje en pantalla
            scanner.nextLine();
            System.out.flush();
        }while (opcion!=0);

    }

}
