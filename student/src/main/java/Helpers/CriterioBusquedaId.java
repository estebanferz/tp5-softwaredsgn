package Helpers;

public class CriterioBusquedaId implements CriterioBusqueda {
    private int id;
    private char alias;


    public CriterioBusquedaId(int id, char alias) {
        this.id = id;
        this.alias = alias;
    }

    @Override
    public String getCriterioBusqueda() {
        return this.alias + ".id = " + this.id;
    }
}
