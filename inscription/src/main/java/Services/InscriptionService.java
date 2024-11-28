package main.java.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Factories.JPARepositoryFactory;
import Helpers.*;
import Modelos.Inscripcion;
import Repositories.InscripcionRepository;
import org.springframework.web.client.RestTemplate;


public class InscriptionService {

    private InscripcionRepository ir;

    public InscriptionService(){
        this.ir = JPARepositoryFactory.getInstance().getInscripcionRepository();
    }


    public Map<String, String> getIndex(){
        Map<String, String> response = new HashMap<>();
        response.put("message", "Inscription index!");
        return response;
    }

    public Map<String,String> postInscription(int id_estudiante, Carrera c){
        Map<String, String> response = new HashMap<>();

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://student-service:8080/student/" + id_estudiante;
        Estudiante[] estudiante = restTemplate.getForObject(url, Estudiante[].class);

        if (estudiante == null || estudiante.length == 0) {
            response.put("message", "No existe el estudiante");
        } else {
            ir.matricular(estudiante[0], c);
            response.put("message", "estudiante matriculado");
        }

        return response;
    }

    public List<Inscripcion> getAllInscriptions(){
        CriterioOrdenamiento crit = new CriterioOrdenamientoNombre('i');
        return ir.getAllCarrerasOrdenadas(crit);
    } 

    public List<Inscripcion> getInscriptionForCarrera(int id){
        CriterioBusqueda crit = new CriterioBusquedaId(id, 'i', "inscripcion_id_carrera");
        return ir.findByCriterio(crit);
    }

    public List<Inscripcion> getInscriptionsForEstudiante(int id){
        CriterioBusqueda crit = new CriterioBusquedaId(id, 'i', "inscripcion_id_estudiante");
        return ir.findByCriterio(crit);
    }

    public Map<String, String> deleteInscriptionsForCarrera(int id){
        CriterioBusqueda crit = new CriterioBusquedaId(id, 'i', "inscripcion_id_carrera");
        ir.deleteByCriterio(crit);
        Map<String, String> response = new HashMap<>();
        response.put("message", "inscripciones de la carrera eliminadas");
        return response;
    }

    public Map<String, String> deleteInscriptionsForEstudiante(int id){
        CriterioBusqueda crit = new CriterioBusquedaId(id, 'i', "inscripcion_id_estudiante");
        ir.deleteByCriterio(crit);
        Map<String, String> response = new HashMap<>();
        response.put("message", "inscripciones del estudiante eliminadas");
        return response;
    }
}
