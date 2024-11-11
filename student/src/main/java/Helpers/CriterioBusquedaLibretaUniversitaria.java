package Helpers;

public class CriterioBusquedaLibretaUniversitaria implements CriterioBusqueda{
    private int libretaUniversitaria;
    private char alias;

    public CriterioBusquedaLibretaUniversitaria(int libretaUniversitaria, char preffix) {
        this.libretaUniversitaria = libretaUniversitaria;
        this.alias = preffix;
    }

    @Override
    public String getCriterioBusqueda() {
        return this.alias + ".libreta = " + this.libretaUniversitaria;
    }

    public char getAlias() {
        return alias;
    }

    public int getLibretaUniversitaria() {
        return libretaUniversitaria;
    }
}
