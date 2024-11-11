package unicen.softwaredsgn.student_inscription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Modelos.Estudiante;
import Modelos.Carrera;
import Modelos.Inscripcion;
import Factories.JPARepositoryFactory;
import Repositories.EstudianteRepository;
import Repositories.InscripcionRepository;
import Helpers.CriterioOrdenamiento;
import Helpers.CriterioOrdenamientoNombre;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Repositories.JPAImplementation.JPAEstudianteRepository;

@RestController
@RequestMapping("/inscription")
public class IncriptionController {
    
    @GetMapping
    public Map<String, String> index(){
        Map<String, String> response = new HashMap<>();
        response.put("message", "Inscription index!");
        return response;
    }

    @PostMapping("/post-inscription")
    public void postInscription(@RequestParam int id_estudiante, @RequestBody Carrera c){
        JPARepositoryFactory repositoryFactory = JPARepositoryFactory.getInstance();
        InscripcionRepository ir = repositoryFactory.getInscripcionRepository();
        ir.matricular(id_estudiante, c);
    }

    @GetMapping("/all-inscriptions")
    public List<Inscripcion> getInscriptions(){
        
        JPARepositoryFactory repositoryFactory = JPARepositoryFactory.getInstance();
        InscripcionRepository ir = repositoryFactory.getInscripcionRepository();
        CriterioOrdenamiento crit = new CriterioOrdenamientoNombre('i');
        System.out.println(ir.getAllCarrerasOrdenadas(crit));

        return ir.getAllCarrerasOrdenadas(crit);
    }
}
