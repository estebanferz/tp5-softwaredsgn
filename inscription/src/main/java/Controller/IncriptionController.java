package unicen.softwaredsgn.student_inscription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Helpers.*;
import Modelos.Inscripcion;
import Factories.JPARepositoryFactory;
import Repositories.InscripcionRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inscription")
public class IncriptionController {
    
    @GetMapping
    public Map<String, String> index(){
        Map<String, String> response = new HashMap<>();
        response.put("message", "Inscription index!");
        return response;
    }

    @PostMapping
    public void postInscription(@RequestParam int id_estudiante, @RequestBody Carrera c){
        JPARepositoryFactory repositoryFactory = JPARepositoryFactory.getInstance();
        InscripcionRepository ir = repositoryFactory.getInscripcionRepository();
        ir.matricular(id_estudiante, c);
    }

    @GetMapping("/all")
    public List<Inscripcion> getInscriptions(){
        
        JPARepositoryFactory repositoryFactory = JPARepositoryFactory.getInstance();
        InscripcionRepository ir = repositoryFactory.getInscripcionRepository();
        CriterioOrdenamiento crit = new CriterioOrdenamientoNombre('i');
        System.out.println(ir.getAllCarrerasOrdenadas(crit));

        return ir.getAllCarrerasOrdenadas(crit);
    }

    @GetMapping("/carrera/{id}")
    public List<Inscripcion> getInscriptionsForCarrera(@PathVariable int id){

        JPARepositoryFactory repositoryFactory = JPARepositoryFactory.getInstance();
        InscripcionRepository ir = repositoryFactory.getInscripcionRepository();
        CriterioBusqueda crit = new CriterioBusquedaId(id, 'i', "inscripcion_id_carrera");

        return ir.findByCriterio(crit);
    }

    @GetMapping("/student/{id}")
    public List<Inscripcion> getInscriptionsForStudent(@PathVariable int id){
        JPARepositoryFactory repositoryFactory = JPARepositoryFactory.getInstance();
        InscripcionRepository ir = repositoryFactory.getInscripcionRepository();
        CriterioBusqueda crit = new CriterioBusquedaId(id, 'i', "inscripcion_id_estudiante");

        return ir.findByCriterio(crit);
    }

    @DeleteMapping("/carrera/{id}")
    public Map<String, String> deleteInscriptionsForCarrera(@PathVariable int id){
        JPARepositoryFactory repositoryFactory = JPARepositoryFactory.getInstance();
        InscripcionRepository ir = repositoryFactory.getInscripcionRepository();
        CriterioBusqueda crit = new CriterioBusquedaId(id, 'i', "inscripcion_id_carrera");
        ir.deleteByCriterio(crit);
        Map<String, String> response = new HashMap<>();
        response.put("message", "inscripciones de la carrera eliminadas");
        return response;
    }

    @DeleteMapping("/student/{id}")
    public Map<String, String> deleteInscriptionsForStudent(@PathVariable int id){
        JPARepositoryFactory repositoryFactory = JPARepositoryFactory.getInstance();
        InscripcionRepository ir = repositoryFactory.getInscripcionRepository();
        CriterioBusqueda crit = new CriterioBusquedaId(id, 'i', "inscripcion_id_estudiante");
        ir.deleteByCriterio(crit);
        Map<String, String> response = new HashMap<>();
        response.put("message", "inscripciones del estudiante eliminadas");
        return response;
    }
}
