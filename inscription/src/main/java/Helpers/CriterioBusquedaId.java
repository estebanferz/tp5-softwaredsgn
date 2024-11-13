package Helpers;

public class CriterioBusquedaId implements CriterioBusqueda {
    private int id;
    private char alias;
    private String idField;

    public CriterioBusquedaId(int id, char alias, String idField) {
        this.id = id;
        this.alias = alias;
        this.idField = idField;
    }

    @Override
    public String getCriterioBusqueda() {
        return this.alias + "." + idField + " = " + this.id;
    }
}
