package Helpers;

public class CriterioOrdenamientoGenero implements CriterioOrdenamiento {
    private char alias;

    public CriterioOrdenamientoGenero(char alias) {
        this.alias = alias;
    }

    @Override
    public String getCriterioOrdenamiento() {
        return alias + ".genero";
    }
}
