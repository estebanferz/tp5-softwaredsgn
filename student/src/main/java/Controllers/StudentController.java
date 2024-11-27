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
import main.java.Services.StudentService;

import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService ss = new StudentService();

    @GetMapping
    public Map<String, String> index(){
        return ss.getIndex();
    }
    
    @GetMapping("/all")
    public List<Estudiante> getAll(){
        return ss.getAllStudents();
    }

    @GetMapping("/{id}")
    public List<Estudiante> getById(@PathVariable int id){
        return ss.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteById(@PathVariable int id){
        return ss.deleteStudent(id);
    }

    @PostMapping
    public Map<String, String> postEstudiante(@RequestBody Estudiante e){
        return ss.postEstudiante(e);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        return ss.updStudent(id, updates);
    }
}
