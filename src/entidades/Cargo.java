/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author OORTIZC
 */
public class Cargo {
    private int int_id_cargo;

    private String str_nombre;
    private int intl_activa;
    
    private String str_descripcion;

    public Cargo() {
    }

    public Cargo(int int_id_cargo, String str_nombre, int intl_activa, String str_descripcion) {
        this.int_id_cargo = int_id_cargo;
        this.str_nombre = str_nombre;
        this.intl_activa = intl_activa;
        this.str_descripcion = str_descripcion;
    }

    public int getInt_id_cargo() {
        return int_id_cargo;
    }

    public void setInt_id_cargo(int int_id_cargo) {
        this.int_id_cargo = int_id_cargo;
    }

    public int getIntl_activa() {
        return intl_activa;
    }

    public void setIntl_activa(int intl_activa) {
        this.intl_activa = intl_activa;
    }

    public String getStr_descripcion() {
        return str_descripcion;
    }

    public void setStr_descripcion(String str_descripcion) {
        this.str_descripcion = str_descripcion;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }
    
     @Override
    public String toString()
    {
        return str_nombre;
    }
     
    
}
