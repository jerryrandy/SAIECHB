/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Toditos
 */
public class Portatil {
    private String Str_id_portatil;
    private String Str_nombre;
    private Componente objComponente;
    private Empleado objEmpleado;
    private Software objSoftware;
    private int int_estado;

    public Portatil() {
    }

    public Portatil(String Str_id_portatil, String Str_nombre, Componente objComponente, Empleado objEmpleado, Software objSoftware, int int_estado) {
        this.Str_id_portatil = Str_id_portatil;
        this.Str_nombre = Str_nombre;
        this.objComponente = objComponente;
        this.objEmpleado = objEmpleado;
        this.objSoftware = objSoftware;
        this.int_estado = int_estado;
    }

    public Software getObjSoftware() {
        return objSoftware;
    }

    public void setObjSoftware(Software objSoftware) {
        this.objSoftware = objSoftware;
    }
    
    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }

    public Componente getObjComponente() {
        return objComponente;
    }

    public void setObjComponente(Componente objComponente) {
        this.objComponente = objComponente;
    }

    public Empleado getObjEmpleado() {
        return objEmpleado;
    }

    public void setObjEmpleado(Empleado objEmpleado) {
        this.objEmpleado = objEmpleado;
    }

    public String getStr_id_portatil() {
        return Str_id_portatil;
    }

    public void setStr_id_portatil(String Str_id_portatil) {
        this.Str_id_portatil = Str_id_portatil;
    }

    public String getStr_nombre() {
        return Str_nombre;
    }

    public void setStr_nombre(String Str_nombre) {
        this.Str_nombre = Str_nombre;
    }


       @Override
    public String toString()
    {
        return Str_nombre;
    }

}
