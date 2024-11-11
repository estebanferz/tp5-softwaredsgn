package Helpers;

public abstract class CriterioOpBinariaOrdenamiento implements CriterioOrdenamiento{

    CriterioOrdenamiento crit1;
    CriterioOrdenamiento crit2;

    public CriterioOpBinariaOrdenamiento(CriterioOrdenamiento crit1, CriterioOrdenamiento crit2){
        this.crit1 = crit1;
        this.crit2 = crit2;
    }
}
