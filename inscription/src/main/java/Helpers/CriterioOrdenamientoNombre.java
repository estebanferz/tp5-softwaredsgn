package Helpers;

public class CriterioOrdenamientoNombre implements CriterioOrdenamiento{

    private char alias;

    public CriterioOrdenamientoNombre(char alias){
        this.alias = alias;
    }
    
    @Override
    public String getCriterioOrdenamiento() {

        return this.alias + ".nombre ASC";
    }
    
}
