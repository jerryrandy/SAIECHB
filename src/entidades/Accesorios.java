package entidades;
import java.io.Serializable;
import java.util.List;


public class Accesorios implements Serializable {

    private String str_id_accesorios;
    private Componente objComponente;

    public Accesorios() {
    }

    public Accesorios(String str_id_accesorios, Componente objComponente) {
        this.str_id_accesorios = str_id_accesorios;
        this.objComponente = objComponente;
    }

    public Componente getObjComponente() {
        return objComponente;
    }

    public void setObjComponente(Componente objComponente) {
        this.objComponente = objComponente;
    }

    public String getStr_id_accesorios() {
        return str_id_accesorios;
    }

    public void setStr_id_accesorios(String str_id_accesorios) {
        this.str_id_accesorios = str_id_accesorios;
    }

    

      @Override
    public String toString()
    {
        return "n/p:"+str_id_accesorios+" - n/s:"+objComponente.getStr_id_componente()+" - "+objComponente.getObjModelo().getObjTipo().getStr_nombre()+" "+
                objComponente.getObjModelo().getObjMarca().getStr_nombre()+" Modelo "+
               objComponente.getObjModelo().getStr_nombre()+" "+
               objComponente.getObjModelo().getObjTipo().getStr_caractarestica()+" "+
               objComponente.getStr_caracteristica();
    }

}
