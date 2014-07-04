/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author Toditos
 */
public class HistorialComponente {
    
    private Componente objcomponente;
    private Date dat_fecha;
    private String str_descripcion;

    public HistorialComponente() {
    }

    public HistorialComponente(Componente objcomponente, Date dat_fecha, String str_descripcion) {
        this.objcomponente = objcomponente;
        this.dat_fecha = dat_fecha;
        this.str_descripcion = str_descripcion;
    }

    public Date getDat_fecha() {
        return dat_fecha;
    }

    public void setDat_fecha(Date dat_fecha) {
        this.dat_fecha = dat_fecha;
    }

    public Componente getObjcomponente() {
        return objcomponente;
    }

    public void setObjcomponente(Componente objcomponente) {
        this.objcomponente = objcomponente;
    }

    public String getStr_descripcion() {
        return str_descripcion;
    }

    public void setStr_descripcion(String str_descripcion) {
        this.str_descripcion = str_descripcion;
    }

    
}
