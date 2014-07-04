/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Toditos
 */
public class Equipo {
    private String str_id_equipo;
    private Componente objComponente;
       private Empleado objEmpleado;
    private int int_estado;
 

    public Equipo() {
    }

    public Equipo(String str_id_equipo, Componente objComponente, Empleado objEmpleado, int int_estado) {
        this.str_id_equipo = str_id_equipo;
        this.objComponente = objComponente;
        this.objEmpleado = objEmpleado;
        this.int_estado = int_estado;
    }

  
    public String getStr_id_equipo() {
        return str_id_equipo;
    }

    public void setStr_id_equipo(String str_id_equipo) {
        this.str_id_equipo = str_id_equipo;
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


       @Override
    public String toString()
    {
        return str_id_equipo;
    }

}
