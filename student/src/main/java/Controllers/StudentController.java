package unicen.softwaredsgn.student_inscription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Modelos.Estudiante;
import Factories.JPARepositoryFactory;
import Repositories.EstudianteRepository;
import Helpers.CriterioBusqueda;
import Helpers.CriterioBusquedaId;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import Repositories.EstudianteRepository;
import Repositories.JPAImplementation.JPAEstudianteRepository;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping
    public Map<String, String> index(){
        Map<String, String> response = new HashMap<>();
        response.put("message", "Students index!");
        return response;
    }
    
    @GetMapping("/all")
    public List<Estudiante> getAll(){
        List<Estudiante> result = new ArrayList<>();

        JPARepositoryFactory repositoryFactory = JPARepositoryFactory.getInstance();
        EstudianteRepository er = repositoryFactory.getEstudianteRepository();


        result = er.find();
        return result;
    }

    @GetMapping("/{id}")
    public List<Estudiante> getById(@PathVariable int id){

        JPARepositoryFactory repositoryFactory = JPARepositoryFactory.getInstance();
        EstudianteRepository er = repositoryFactory.getEstudianteRepository();
        CriterioBusqueda crit = new CriterioBusquedaId(id, 'e');

        return er.findByCriterio(crit);
    }

    @PostMapping
    public void postEstudiante(@RequestBody Estudiante e){
        JPARepositoryFactory repositoryFactory = JPARepositoryFactory.getInstance();
        EstudianteRepository er = repositoryFactory.getEstudianteRepository();
        er.postEstudiante(e);
    }
}
