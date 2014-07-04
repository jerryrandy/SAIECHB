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
public class Registro {
    
    private int int_id_registro;
    private Computador objComputador;
    private Date date_fecah;
    private int int_tipo;
    private String str_descripcion;

    public Registro() {
    }

    public Registro(int int_id_registro, Computador objComputador, Date date_fecah, int int_tipo, String str_descripcion) {
        this.int_id_registro = int_id_registro;
        this.objComputador = objComputador;
        this.date_fecah = date_fecah;
        this.int_tipo = int_tipo;
        this.str_descripcion = str_descripcion;
    }

    public Date getDate_fecah() {
        return date_fecah;
    }

    public void setDate_fecah(Date date_fecah) {
        this.date_fecah = date_fecah;
    }

    public int getInt_id_registro() {
        return int_id_registro;
    }

    public void setInt_id_registro(int int_id_registro) {
        this.int_id_registro = int_id_registro;
    }

    public int getInt_tipo() {
        return int_tipo;
    }

    public void setInt_tipo(int int_tipo) {
        this.int_tipo = int_tipo;
    }

    public Computador getObjComputador() {
        return objComputador;
    }

    public void setObjComputador(Computador objComputador) {
        this.objComputador = objComputador;
    }

    public String getStr_descripcion() {
        return str_descripcion;
    }

    public void setStr_descripcion(String str_descripcion) {
        this.str_descripcion = str_descripcion;
    }
    
    @Override
    public String toString()
    {
        return str_descripcion;
    }
}
