package Services;


import java.util.List;

import DTOs.ReporteCarrerasDTO;
import DTOs.ReporteCarrerasDTO.ItemReporte;
import DTOs.ReporteCarrerasDTO.ItemReporte.EstudianteFecha;
import Helpers.CriterioOrdenamiento;
import Helpers.CriterioOrdenamientoInscripcion;
import Helpers.CriterioOrdenamientoNombre;
import Repositories.JPAImplementation.JPAEstudianteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

//REIMPLEMENTAR PARA BUSCAR EN DISTINTAS BASES CON RESTTEMPLATE
public class ReporteService {
    public ReporteCarrerasDTO getReporte(){

        EntityManager em = Persistence.createEntityManagerFactory("persistencia").createEntityManager();
        // JPACarreraRepository cr = new JPACarreraRepository(em);
        // JPAInscripcionRepository ir = new JPAInscripcionRepository(em);
        // JPAEstudianteRepository er =  new JPAEstudianteRepository(em);

        // //Get de lista de Carreras, ordenadas alfabeticamente
        // CriterioOrdenamiento crit = new CriterioOrdenamientoNombre('c');
        // List<Carrera> lista_carrera = cr.getAllCarrerasOrdenadas(crit);

        // //Get de lista de Inscripciones, ordenadas cronologicamente por fecha_inscripcion
        // CriterioOrdenamiento crit2 = new CriterioOrdenamientoInscripcion('i');
        // List<Inscripcion> lista_inscripcion = ir.getAllCarrerasOrdenadas(crit2);
        
        ReporteCarrerasDTO dto = new ReporteCarrerasDTO();

        // for (Carrera carrera: lista_carrera){   //Itera por carreras ordenadas
            ItemReporte itemReporte = dto.new ItemReporte();
        //     for(Inscripcion inscripcion: lista_inscripcion){    //Itera por las inscripciones ordenadas
        //         if (inscripcion.getCarrera().equals(carrera)){
        //             EstudianteFecha estudiante = itemReporte.new EstudianteFecha(er.getById(inscripcion.getIdEstudiante()));
        //             estudiante.setInscripcion(ir.findById(inscripcion.getIdCarrera(), inscripcion.getIdEstudiante()).getInscripcion());
        //             itemReporte.addItem(estudiante);
        //         }
        //     }
        //     dto.addItemReporte(itemReporte);
        // }

        return dto;
    }
}
