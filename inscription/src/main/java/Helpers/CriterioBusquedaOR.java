package Helpers;

public class CriterioBusquedaOR extends CriterioBusquedaBinario {
    public CriterioBusquedaOR(CriterioBusqueda criterioBusqueda1, CriterioBusqueda criterioBusqueda2) {
        super(criterioBusqueda1, criterioBusqueda2);
    }

    @Override
    public String getCriterioBusqueda() {
        return criterioBusqueda1.getCriterioBusqueda() + " OR " + criterioBusqueda2.getCriterioBusqueda();
    }
}
