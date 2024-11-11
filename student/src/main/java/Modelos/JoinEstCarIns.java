package Modelos;

import java.util.Date;

public class JoinEstCarIns {
    private int join_id_carrera;
    private int join_id_estudiante;
    private String nombre_carrera;
    private Date fecha_inscripcion;
    private Date fecha_graduacion;
    private String nombre_estudiante;
    private int edad;
    private int dni;
    private int libreta;


    public JoinEstCarIns(int id_carrera, int id_estudiante, String nombre_est, String nombre_car, Date ins, Date grad, int edad, int dni, int legajo){
        this.dni = dni;
        this.edad = edad;
        this.fecha_graduacion = grad;
        this.fecha_inscripcion = ins;
        this.join_id_carrera = id_carrera;
        this.join_id_estudiante = id_estudiante;
        this.libreta = legajo;
        this.nombre_carrera = nombre_car;
        this.nombre_estudiante = nombre_est;
    }

    
    public JoinEstCarIns(Carrera carrera, Inscripcion inscripcion, Estudiante estudiante){
        this.dni = estudiante.getDni();
        this.edad = estudiante.getEdad();
        this.fecha_graduacion = inscripcion.getGraduacion();
        this.fecha_inscripcion = inscripcion.getInscripcion();
        this.join_id_carrera = carrera.getId();
        this.join_id_estudiante = estudiante.getId();
        this.libreta = estudiante.getLibreta();
        this.nombre_carrera = carrera.getNombre();
        this.nombre_estudiante = estudiante.getNombre();
    }

    @Override
    public String toString() {
        return "Join{" +
                "id_estudiante=" + join_id_estudiante +
                ", id_carrera=" + join_id_carrera +
                ", fecha_inscripcion=" + fecha_inscripcion +
                ", fecha_graduacion=" + fecha_graduacion +
                ", dni=" + dni +
                ", edad=" + edad +
                ", libreta=" + libreta +
                ", nombre carrera=" + nombre_carrera +
                ", nombre estudiante=" + nombre_estudiante +
                '}';
    }

    
}
