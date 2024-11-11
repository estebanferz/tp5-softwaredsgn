package Helpers;

public class CriterioBusquedaCiudadResidencia implements CriterioBusqueda{

    private String ciudad;
    private char alias;

    public CriterioBusquedaCiudadResidencia(String ciudad, char preffix) {
        this.ciudad = ciudad;
        this.alias = preffix;
    }

    @Override
    public String getCriterioBusqueda() {
        return this.alias + ".ciudad = '" + this.ciudad + "'";
    }

    public char getAlias() {
        return alias;
    }
}
