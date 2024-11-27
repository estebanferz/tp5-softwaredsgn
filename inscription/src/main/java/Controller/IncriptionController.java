package unicen.softwaredsgn.student_inscription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Helpers.*;
import Modelos.Inscripcion;
import Factories.JPARepositoryFactory;
import Repositories.InscripcionRepository;
import main.java.Services.InscriptionService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inscription")
public class IncriptionController {

    private InscriptionService is = new InscriptionService();
    
    @GetMapping
    public Map<String, String> index(){
        return is.getIndex();
    }

    @PostMapping
    public void postInscription(@RequestParam int id_estudiante, @RequestBody Carrera c){
        is.postInscription(id_estudiante, c);
    }

    @GetMapping("/all")
    public List<Inscripcion> getInscriptions(){
        return is.getAllInscriptions();
    }

    @GetMapping("/carrera/{id}")
    public List<Inscripcion> getInscriptionsForCarrera(@PathVariable int id){
        return is.getInscriptionForCarrera(id);
    }

    @GetMapping("/student/{id}")
    public List<Inscripcion> getInscriptionsForStudent(@PathVariable int id){
        return is.getInscriptionsForEstudiante(id);
    }

    @DeleteMapping("/carrera/{id}")
    public Map<String, String> deleteInscriptionsForCarrera(@PathVariable int id){
        return is.deleteInscriptionsForCarrera(id);
    }

    @DeleteMapping("/student/{id}")
    public Map<String, String> deleteInscriptionsForStudent(@PathVariable int id){
        return is.deleteInscriptionsForEstudiante(id);
    }
}