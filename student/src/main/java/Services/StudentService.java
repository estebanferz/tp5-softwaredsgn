package main.java.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Factories.JPARepositoryFactory;
import Helpers.*;
import Modelos.Estudiante;
import Repositories.EstudianteRepository;
import Helpers.CriterioBusquedaId;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;


public class StudentService {

    private EstudianteRepository er;

    public StudentService(){
        this.er = JPARepositoryFactory.getInstance().getEstudianteRepository();
    }


    public Map<String, String> getIndex(){
        Map<String, String> response = new HashMap<>();
        response.put("message", "Students index!");
        return response;
    }

    public Map<String, String> postEstudiante(Estudiante e){
        er.postEstudiante(e);
        HashMap<String, String> response = new HashMap<String, String>();
        response.put("agregado", "true");
        return response;
    }

    public List<Estudiante> getAllStudents(){
        List<Estudiante> result = new ArrayList<>();
        result = er.find();
        return result;
    } 

    public List<Estudiante> getStudentById(int id){
        CriterioBusqueda crit = new CriterioBusquedaId(id, 'e');
        return er.findByCriterio(crit);
    }

    public ResponseEntity<Estudiante> updStudent(int id, Map<String, Object> updates){
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
    public Map<String, String> deleteStudent(int id){
        // Borrar las inscripciones de un usuario
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://inscription-service:8080/inscription/student/{id}";
        restTemplate.delete(url, id);

        er.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Estudiante eliminado");
        return response;
    }
}
