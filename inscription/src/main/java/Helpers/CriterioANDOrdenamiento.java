package Helpers;

public class CriterioANDOrdenamiento extends CriterioOpBinariaOrdenamiento{
   
    public CriterioANDOrdenamiento(CriterioOrdenamiento crit1, CriterioOrdenamiento crit2) {
        super(crit1, crit2);
    }

    @Override
    public String getCriterioOrdenamiento() {
        return crit1.getCriterioOrdenamiento() + ", " + crit2.getCriterioOrdenamiento();
    }
    
}
