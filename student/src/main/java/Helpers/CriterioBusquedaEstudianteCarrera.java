package Helpers;

import Modelos.Carrera;

public class CriterioBusquedaEstudianteCarrera implements CriterioBusqueda{

    private String carrera;

    public CriterioBusquedaEstudianteCarrera(Carrera carrera){
        this.carrera = carrera.getNombre();
    }

    @Override
    public String getCriterioBusqueda() {
        return "e.id IN (SELECT e.id FROM Inscripcion i JOIN Carrera c ON i.inscripcion_id_carrera = c.id JOIN Estudiante e ON e.id = i.inscripcion_id_estudiante WHERE c.nombre = '" + this.carrera + "')";
    }
    
}
