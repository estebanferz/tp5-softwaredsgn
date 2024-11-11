package Helpers;

public class CriterioOrdenamientoInscripcion implements CriterioOrdenamiento{

    private char alias;

    public CriterioOrdenamientoInscripcion(char alias){
        this.alias = alias;
    }

    @Override
    public String getCriterioOrdenamiento() {
        return this.alias + ".fecha_inscripcion ASC";
    }
    
}
