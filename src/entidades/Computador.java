/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author prac_hbt
 */
public class Computador {
    private String str_id_computador;
    private CPU objCPU;
    private Monitor objMonitor;
    private Empleado objEmpleado;
    private int int_estado;

    public Computador() {
    }

    public Computador(String str_id_computador, CPU objCPU, Monitor objMonitor, Empleado objEmpleado, int int_estado) {
        this.str_id_computador = str_id_computador;
        this.objCPU = objCPU;
        this.objMonitor = objMonitor;
        this.objEmpleado = objEmpleado;
        this.int_estado = int_estado;
    }

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }

    public CPU getObjCPU() {
        return objCPU;
    }

    public void setObjCPU(CPU objCPU) {
        this.objCPU = objCPU;
    }

    public Empleado getObjEmpleado() {
        return objEmpleado;
    }

    public void setObjEmpleado(Empleado objEmpleado) {
        this.objEmpleado = objEmpleado;
    }

    public Monitor getObjMonitor() {
        return objMonitor;
    }

    public void setObjMonitor(Monitor objMonitor) {
        this.objMonitor = objMonitor;
    }

    public String getStr_id_computador() {
        return str_id_computador;
    }

    public void setStr_id_computador(String str_id_computador) {
        this.str_id_computador = str_id_computador;
    }
    

    @Override
      public String toString()
    {
        return str_id_computador;
    }
    
}
