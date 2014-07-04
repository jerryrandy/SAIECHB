/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Toditos
 */
public class Monitor {
    private String str_id_monitor;
    private Componente objComponente;

    public Monitor() {
    }

    public Monitor(String str_id_monitor, Componente objComponente) {
        this.str_id_monitor = str_id_monitor;
        this.objComponente = objComponente;
    }


    public Componente getObjComponente() {
        return objComponente;
    }

    public void setObjComponente(Componente objComponente) {
        this.objComponente = objComponente;
    }

    public String getStr_id_monitor() {
        return str_id_monitor;
    }

    public void setStr_id_monitor(String str_id_monitor) {
        this.str_id_monitor = str_id_monitor;
    }
    

    

       @Override
    public String toString()
    {
        return String.valueOf(objComponente);
    }

}
