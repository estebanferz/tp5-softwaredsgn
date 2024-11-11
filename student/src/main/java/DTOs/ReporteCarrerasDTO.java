package DTOs;

import Modelos.Carrera;
import Modelos.Estudiante;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class ReporteCarrerasDTO {
    public class ItemReporte {
        public class EstudianteFecha{
            private Estudiante estudiante;
            private Date fecha_inscripcion;
            
            public EstudianteFecha(Estudiante estudiante){
                this.estudiante = estudiante;
            }

            public void setInscripcion(Date inscripcion){
                this.fecha_inscripcion = inscripcion;
            }
        }

        private Carrera carrera;
        List<EstudianteFecha> estudiantes;

        public ItemReporte(Carrera carrera) {
            this.carrera = carrera;
            estudiantes = new ArrayList<>();
        }

        public Carrera getCarrera() {
            return carrera;
        }


        public void addItem(EstudianteFecha estudiante) {
            this.estudiantes.add(estudiante);
        }

        public List<EstudianteFecha> getEstudiantes() {
            return estudiantes;
        }
    }

    private List<ItemReporte> itemReporte;

    public ReporteCarrerasDTO(){
        this.itemReporte = new ArrayList<>();
    }

    public void addCarrera(Carrera carrera){
        ItemReporte item = new ItemReporte(carrera);
        this.itemReporte.add(item);
    }

    public void addItemReporte(ItemReporte i){
        this.itemReporte.add(i);
    }

    public String toString(){
        String result = "DTO{\n";
        for (ItemReporte item: itemReporte){
            result = result + item.carrera + "=[{\n";
            for (ItemReporte.EstudianteFecha estudiante: item.estudiantes){
                result = result + estudiante.estudiante + "|| fecha inscripcion: " + estudiante.fecha_inscripcion + "}\n";
            }
            result = result + "]\n";
        }

        return result;
    }
}