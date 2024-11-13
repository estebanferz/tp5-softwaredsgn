package unicen.softwaredsgn.student_inscription;

import java.util.*;

import Modelos.Estudiante;
import Factories.JPARepositoryFactory;
import Repositories.EstudianteRepository;
import Helpers.CriterioBusqueda;
import Helpers.CriterioBusquedaId;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{id}")
    public Map<String, String> deleteById(@PathVariable int id){
        JPARepositoryFactory repositoryFactory = JPARepositoryFactory.getInstance();
        EstudianteRepository er = repositoryFactory.getEstudianteRepository();
        er.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Estudiante eliminado");
        return response;
    }

    @PostMapping
    public Map<String, String> postEstudiante(@RequestBody Estudiante e){
        JPARepositoryFactory repositoryFactory = JPARepositoryFactory.getInstance();
        EstudianteRepository er = repositoryFactory.getEstudianteRepository();
        er.postEstudiante(e);
        HashMap<String, String> response = new HashMap<String, String>();
        response.put("agregado", "true");
        return response;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        JPARepositoryFactory repositoryFactory = JPARepositoryFactory.getInstance();
        EstudianteRepository er = repositoryFactory.getEstudianteRepository();
        CriterioBusqueda crit = new CriterioBusquedaId(id, 'e');
        List<Estudiante> estudianteOptional = er.findByCriterio(crit);

        if (estudianteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Estudiante estudiante = estudianteOptional.get(0);

        // Apply updates from the map to the Estudiante instance
        updates.forEach((key, value) -> {
            switch (key) {
                case "nombre":
                    estudiante.setNombre((String) value);
                    break;
                case "apellido":
                    estudiante.setApellido((String) value);
                    break;
                case "edad":
                    estudiante.setEdad((Integer) value);
                    break;
                case "genero":
                    estudiante.setGenero(((String) value).charAt(0));
                    break;
                case "dni":
                    estudiante.setDni((Integer) value);
                    break;
                case "ciudad":
                    estudiante.setCiudad((String) value);
                    break;
                case "libreta":
                    estudiante.setLibreta((Integer) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field " + key + " is not updatable");
            }
        });

        er.persist(estudiante);
        return ResponseEntity.ok(estudiante);
    }
}
