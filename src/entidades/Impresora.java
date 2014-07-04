/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Toditos
 */
public class Impresora {
    private String str_id_impresora;
    private Componente objComponente;
    private Empleado objEmpleado;
    private int int_estado;
    

    public Impresora() {
    }

    public Impresora(String str_id_impresora, Componente objComponente, Empleado objEmpleado, int int_estado) {
        this.str_id_impresora = str_id_impresora;
        this.objComponente = objComponente;
        this.objEmpleado = objEmpleado;
        this.int_estado = int_estado;
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

    public String getStr_id_impresora() {
        return str_id_impresora;
    }

    public void setStr_id_impresora(String str_id_impresora) {
        this.str_id_impresora = str_id_impresora;
    }
    

       @Override
    public String toString()
    {
        return str_id_impresora;
    }

}
