package unicen.softwaredsgn.student_inscription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Modelos.Estudiante;
import Factories.JPARepositoryFactory;
import Repositories.EstudianteRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Repositories.EstudianteRepository;
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
}
