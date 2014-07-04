/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author OORTIZC
 */
public class Empleado {
 
    private int int_id_empleado;
    private Cargo objCargo;
    private Area objArea;
    private String str_apellido;
    private String str_nombre;   
    private String str_usuario;
    private int int_activa;
    private int int_estado;

    public Empleado() {
    }

    public Empleado(int int_id_empleado, Cargo objCargo, Area objArea, String str_apellido, String str_nombre, String str_usuario, int int_activa, int int_estado) {
        this.int_id_empleado = int_id_empleado;
        this.objCargo = objCargo;
        this.objArea = objArea;
        this.str_apellido = str_apellido;
        this.str_nombre = str_nombre;
        this.str_usuario = str_usuario;
        this.int_activa = int_activa;
        this.int_estado = int_estado;
    }

  

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }

   

    public int getInt_activa() {
        return int_activa;
    }

    public void setInt_activa(int int_activa) {
        this.int_activa = int_activa;
    }

    public int getInt_id_empleado() {
        return int_id_empleado;
    }

    public void setInt_id_empleado(int int_id_empleado) {
        this.int_id_empleado = int_id_empleado;
    }

    public Area getObjArea() {
        return objArea;
    }

    public void setObjArea(Area objArea) {
        this.objArea = objArea;
    }

    public Cargo getObjCargo() {
        return objCargo;
    }

    public void setObjCargo(Cargo objCargo) {
        this.objCargo = objCargo;
    }

    public String getStr_apellido() {
        return str_apellido;
    }

    public void setStr_apellido(String str_apellido) {
        this.str_apellido = str_apellido;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }

    public String getStr_usuario() {
        return str_usuario;
    }

    public void setStr_usuario(String str_usuario) {
        this.str_usuario = str_usuario;
    }
    
     @Override
    public String toString()
    {
        return str_apellido +" "+ str_nombre;
    }
    
    
}
