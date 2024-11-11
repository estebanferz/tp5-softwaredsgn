package Helpers;

public class CriterioBusquedaGenero implements CriterioBusqueda {
    private char genero;
    private char alias;

    public CriterioBusquedaGenero(char genero, char preffix) {
        this.genero = genero;
        this.alias = preffix;
    }

    @Override
    public String getCriterioBusqueda() {
        return this.alias + ".genero = '" + this.genero + "'";
    }

    public char getAlias() {
        return alias;
    }

    public int getLibretaUniversitaria() {
        return genero;
    }
}
